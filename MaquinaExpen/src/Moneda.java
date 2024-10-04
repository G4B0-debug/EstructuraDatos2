public class Moneda {
    private double valor;
    private int cantidad;

    public Moneda(double valor) {
        this.valor = valor;
        this.cantidad = 0;
    }

    public double getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void agregar(int cantidad) {
        this.cantidad += cantidad;
    }

    public boolean quitar(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            return true;
        }
        return false;
    }
}
