package banco;

public class LinkedQueue {
    private Nodo front;
    private Nodo rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public synchronized int size() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized void enqueue(Object value) {
        Nodo nodo = new Nodo();
        nodo.setValor(value);
        if (isEmpty()) {
            front = nodo;
            rear = nodo;
        } else {
            rear.setEnlace(nodo);
            rear = nodo;
        }
        size++;
    }

    public synchronized Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            size--;
            value = front.getValor();
            front = front.getEnlace();
        }
        return value;
    }

    @Override
    public synchronized String toString() {
        StringBuilder s = new StringBuilder();
        Nodo t = front;
        while (t != null) {
            s.append(t.getValor()).append("<");
            t = t.getEnlace();
        }
        return s.toString();
    }
}
