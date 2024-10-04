package BBVA;

public class Cliente {
    private String tipo;
    private boolean operacion; // true para depósito, false para retiro
    private double monto;

    public Cliente(String tipo, boolean operacion, double monto) {
        this.tipo = tipo;
        this.operacion = operacion;
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isOperacion() {
        return operacion;
    }

    public double getMonto() {
        return monto;
    }
}
