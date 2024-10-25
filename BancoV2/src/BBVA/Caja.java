package BBVA;

public class Caja {
    private double totalDinero;
    private boolean ocupada;

    public Caja() {
        this.totalDinero = 0;
        this.ocupada = false;
    }

    public void depositar(double monto, double denominacion) {
        totalDinero += monto;
        System.out.println("Depositado: " + monto + " con denominación de: " + denominacion);
    }

    public void retirar(double monto) {
        if (totalDinero >= monto) {
            totalDinero -= monto;
            System.out.println("Retirado: " + monto);
        } else {
            System.out.println("Fondos insuficientes en la caja.");
        }
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void mostrarDineroEnCaja() {
        System.out.println("Dinero en caja: " + totalDinero);
    }
}
