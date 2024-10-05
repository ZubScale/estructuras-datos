package banco;

import java.util.Random;

public class Caja {
    private int id;  // ID de la caja
    private ColaDinero colaDinero;  // Cola de dinero de la caja
    private double saldo;  // Saldo actual de la caja
    private long tiempoEsperado;  // Tiempo de espera total en milisegundos
    private long tiempoRestante;  // Tiempo restante para la atención del cliente actual

    public Caja(int id, ColaDinero colaDinero, double saldoInicial) {
        this.id = id;
        this.colaDinero = colaDinero;
        this.saldo = saldoInicial;
        this.tiempoEsperado = 0;  // Inicializar el tiempo de espera a 0
        this.tiempoRestante = 0;  // Inicializar el tiempo restante a 0
    }

    public void atenderCliente(Cliente cliente) {
        // Crear un nuevo hilo para atender al cliente
        new Thread(() -> {
            // Simular el tiempo que toma atender al cliente
            long tiempoAtencion = cliente.isCuentahabiente() 
                    ? getRandomTime(10000, 15000)  // Tiempo de atención para cuentahabientes
                    : getRandomTime(15000, 20000); // Tiempo de atención para clientes normales
            
            // Determinar si el cliente hará un depósito o un retiro
            boolean esRetiro = new Random().nextBoolean();  // 50% de probabilidad para cada acción

            synchronized (this) {
                tiempoEsperado += tiempoAtencion;  // Actualizar el tiempo de espera total
                tiempoRestante = tiempoAtencion;  // Establecer el tiempo restante para el cliente actual
            }

            String tipoCliente = cliente.isCuentahabiente() ? "cuentahabiente" : "cliente normal";
            String accion = esRetiro ? "retiro" : "depósito";
            System.out.println("Atendiendo al " + tipoCliente + " en la Caja " + id + 
                               " por " + (tiempoAtencion / 1000) + " segundos. Acción: " + accion);

            try {
                while (tiempoRestante > 0) {
                    // Actualizar el tiempo restante cada segundo
                    Thread.sleep(1000);  // Simular el tiempo real
                    synchronized (this) {
                        tiempoRestante -= 1000;  // Disminuir el tiempo restante
                    }
                }

                // Simular el monto del retiro o depósito
                double monto = getRandomMonto(100, 4000);  // Generar un monto aleatorio
                if (esRetiro) {
                    realizarRetiro(monto);
                } else {
                    realizarDeposito(monto);
                }

                // Actualizar el estado de la caja después de atender al cliente
                actualizarEstado();

                System.out.println("Cliente " + tipoCliente + " ha salido de la Caja " + id + ". Acción: " + accion + " por $" + monto);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start(); // Inicia el hilo para atender al cliente
    }

    private void realizarRetiro(double monto) {
        synchronized (this) {
            if (saldo >= monto) {
                saldo -= monto;  // Reducir el saldo en la cantidad retirada
                System.out.println("Se realizó un retiro de $" + monto + " en la Caja " + id);
            } else {
                System.out.println("Fondos insuficientes para realizar el retiro de $" + monto + " en la Caja " + id);
            }
        }
    }

    private void realizarDeposito(double monto) {
        synchronized (this) {
            saldo += monto;  // Aumentar el saldo en la cantidad depositada
            System.out.println("Se realizó un depósito de $" + monto + " en la Caja " + id);
        }
    }

    private void actualizarEstado() {
        synchronized (this) {
            System.out.println("Estado actualizado de la Caja " + id + ": Saldo: $" + saldo + ", Tiempo total de espera: " + (tiempoEsperado / 1000) + " segundos.");
            tiempoEsperado = 0;  // Reiniciar el tiempo de espera después de atender al cliente
        }
    }

    private long getRandomTime(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;  // Generar tiempo aleatorio entre min y max
    }

    private double getRandomMonto(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;  // Generar monto aleatorio entre min y max
    }

    public double getSaldo() {
        return saldo;  // Retornar el saldo actual de la caja
    }

    public long getTiempoEsperado() {
        return tiempoEsperado;  // Retornar el tiempo de espera
    }

    public int getId() {
        return id;  // Retornar el ID de la caja
    }
}

