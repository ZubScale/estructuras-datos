package banco;

import java.util.Random;
import java.util.Scanner;

public class Banco {
    private static final int NUM_CAJAS = 4;  // Número de cajas en el banco
    private static final int TIEMPO_GENERACION_CLIENTES = 5000; // Tiempo para generar nuevos clientes en milisegundos (5 segundos)
    private static final double SALDO_INICIAL = 100000; // Saldo inicial para cada caja

    private Caja[] cajas;  // Array que contiene las cajas del banco

    public Banco() {
        this.cajas = new Caja[NUM_CAJAS];  // Inicializar el array de cajas
        ColaDinero colaDinero = new ColaDinero(new double[]{0.50, 1, 2, 5, 10, 20, 100, 200, 500, 1000}, 100);  // Inicializar la cola de dinero

        // Crear las cajas del banco
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas[i] = new Caja(i + 1, colaDinero, SALDO_INICIAL);
        }
    }

    public void iniciar() {
        // Hilo para generar clientes automáticamente
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    // Esperar 5 segundos para la llegada de nuevos clientes
                    Thread.sleep(TIEMPO_GENERACION_CLIENTES); // Esperar para generar nuevos clientes
                    String tipoCliente = random.nextBoolean() ? "cuentahabiente" : "cliente normal"; // Determinar el tipo de cliente
                    Cliente cliente = new Cliente(tipoCliente);  // Crear nuevo cliente
                    int cajaSeleccionada = random.nextInt(NUM_CAJAS);  // Seleccionar una caja aleatoria
                    System.out.println("Cliente " + tipoCliente + " llega a la Caja " + (cajaSeleccionada + 1));
                    cajas[cajaSeleccionada].atenderCliente(cliente);  // Atender al cliente en la caja seleccionada
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void mostrarEstadisticasCajas() {
        while (true) {
            try {
                Thread.sleep(10000); // Actualizar cada 10 segundos
                for (Caja caja : cajas) {
                    System.out.println("CAJA " + caja.getId() + "  $" + caja.getSaldo() + " - Tiempo de espera: " + (caja.getTiempoEsperado() / 1000) + "s");
                }
                System.out.println("------------------------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();  // Crear una nueva instancia de Banco
        banco.iniciar();  // Iniciar el banco

        // Hilo para mostrar las estadísticas de las cajas
        new Thread(() -> {
            banco.mostrarEstadisticasCajas();  // Mostrar estadísticas de las cajas
        }).start();

        // Esperar la entrada del usuario para terminar el programa
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona '1' para terminar el programa.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("Terminando el programa...");
                System.exit(0);  // Terminar el programa
            }
        }
    }
}
