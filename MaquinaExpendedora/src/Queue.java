public class Queue {
    private int f; // Frente de la cola
    private int r; // Final de la cola
    private int size; // Cantidad de elementos actuales en la cola
    private Object[] queue; // Arreglo que actúa como cola

    // Constructor que inicializa la cola con un tamaño dado
    public Queue(int size) {
        this.f = 0;  // Frente
        this.r = 0;  // Final
        this.queue = new Object[size];  // Arreglo que simula la cola
        this.size = 0;  // Tamaño actual de la cola
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para verificar si la cola está llena
    public boolean isFull() {
        return size == queue.length;
    }

    // Método para agregar un valor a la cola
    public void enqueue(Object value) {
        if (!isFull()) {
            queue[r] = value;  // Se agrega al final de la cola
            r = (r + 1) % queue.length;  // Avanza el índice circularmente
            size++;
        } else {
            System.out.println("La cola está llena. No se puede agregar más elementos.");
        }
    }

    // Método para eliminar y devolver el valor del frente de la cola
    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            value = queue[f];  // Toma el valor del frente de la cola
            queue[f] = null;   // Limpia el espacio
            f = (f + 1) % queue.length;  // Avanza el índice circularmente
            size--;
        } else {
            System.out.println("La cola está vacía.");
        }
        return value;
    }

    // Método para obtener el valor del frente de la cola (sin eliminarlo)
    public Object front() {
        if (!isEmpty()) {
            return queue[f];
        }
        return null;
    }

    // Método para obtener el valor del final de la cola (sin eliminarlo)
    public Object rear() {
        if (!isEmpty()) {
            int tempR = (r - 1 + queue.length) % queue.length;
            return queue[tempR];
        }
        return null;
    }

    // Sobrescribir el método toString para mostrar el contenido de la cola
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int index = (f + i) % queue.length;  // Índice circular para recorrer la cola
            s.append(queue[index]).append(">");
        }
        return s.toString();
    }
}
