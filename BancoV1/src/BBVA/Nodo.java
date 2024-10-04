package BBVA;

public class Nodo {
    private Object valor;
    private Nodo enlace;

    public Object getValor() {
        return valor;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
