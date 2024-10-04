package BBVA;

public class LinkedQueue {
    private Nodo front;
    private Nodo rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Object value) {
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

    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            size--;
            value = front.getValor();
            front = front.getEnlace();
        }
        return value;
    }

    public String toString() {
        String s = "";
        Nodo t = front;
        while (null != t) {
            s += t.getValor() + "<";
            t = t.getEnlace();
        }
        return s;
    }
}
