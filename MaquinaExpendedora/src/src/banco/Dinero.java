package banco;

public class Dinero {
    private double valor;
    private LinkedQueue unidades;

    public Dinero(double valor, int capacidadUnidades) {
        this.valor = valor;
        this.unidades = new LinkedQueue();
    }

    public void agregarUnidad(Object unidad) {
        unidades.enqueue(unidad);
    }

    public Object usarUnidad() {
        return unidades.dequeue();
    }

    public boolean estaLleno() {
        return false; // Implementar la lógica según la capacidad
    }

    public boolean estaVacio() {
        return unidades.isEmpty();
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Valor: " + valor + " - Unidades: " + unidades.toString();
    }
}
