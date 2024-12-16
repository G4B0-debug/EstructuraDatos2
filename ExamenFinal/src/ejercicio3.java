public class ejercicio3 {

}

class NumericPriorityQueue {
    private NumericNodo front;
    private NumericNodo rear;
    private int size;

    public NumericPriorityQueue() {
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


    public void enqueue1(NumericNodo nodo) {
        if (isEmpty()) {
            front = nodo;
            rear = nodo;
        } else {
            rear.setEnlace(nodo);
            rear = nodo;
        }
    }


    public void enqueue(Object value, Integer prioridad) {
        NumericNodo n = new NumericNodo();
        n.setValor(value);
        n.setPrioridad(prioridad);
        if (isEmpty()) {
            front = n;
            rear = n;
        } else {
            if (prioridad >= rear.getPrioridad()) {
                enqueue1(n);
            } else {
                NumericNodo actual = front;
                NumericNodo siguiente = front.getEnlace();
                if (prioridad < front.getPrioridad()) {
                    n.setEnlace(front);
                    front = n;
                } else {
                    while (null != siguiente) {
                        if (prioridad < siguiente.getPrioridad()) {
                            break;
                        }
                        actual = siguiente;
                        siguiente = siguiente.getEnlace();
                    }
                    actual.setEnlace(n);
                    n.setEnlace(siguiente);
                }
            }
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
        NumericNodo t = front;
        while (null != t) {
            s += t.getValor() + "<";
            t = t.getEnlace();
        }
        return s;
    }
}

class NumericNodo {
    private Object valor;
    private Integer prioridad;
    private NumericNodo enlace;

    public Object getValor() {
        return valor;
    }

    public NumericNodo getEnlace() {
        return enlace;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setEnlace(NumericNodo enlace) {
        this.enlace = enlace;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
