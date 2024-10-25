package BBVA;

public class Cliente {
    private String tipo;
    private boolean operacion; // true para depósito, false para retiro
    private double monto;
    private String numeroCuenta;

    public Cliente(String tipo, boolean operacion, double monto, String numeroCuenta) {
        this.tipo = tipo;
        this.operacion = operacion;
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
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

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
