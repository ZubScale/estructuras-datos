public class Dinero {
    private double valor;
    private Queue unidades;

    public Dinero(double valor, int capacidadUnidades) {
        this.valor = valor;
        this.unidades = new Queue(capacidadUnidades);
    }

    public void agregarUnidad(Object unidad) {
        unidades.enqueue(unidad);
    }

    public Object usarUnidad() {
        return unidades.dequeue();
    }

    public boolean estaLleno() {
        return unidades.isFull();
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
