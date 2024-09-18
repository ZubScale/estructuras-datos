public class Productos {
    private String nombre;
    private Queue unidades;

    public Productos(String nombre, int capacidadUnidades) {
        this.nombre = nombre;
        this.unidades = new Queue(capacidadUnidades);
    }

    public void agregarUnidad(Object unidad) {
        unidades.enqueue(unidad);
    }

    public Object venderUnidad() {
        return unidades.dequeue();
    }

    public boolean estaLleno() {
        return unidades.isFull();
    }

    public boolean estaVacio() {
        return unidades.isEmpty();
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre + ": " + unidades.toString();
    }
}
