package BBVA;

public class Banco {
    private LinkedQueue colaConCuenta = new LinkedQueue();
    private LinkedQueue colaSinCuenta = new LinkedQueue();
    private Caja[] cajas = new Caja[4];
    private double montoTotal;

    public Banco(double montoInicial) {
        this.montoTotal = montoInicial;
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente.getTipo().equals("conCuenta")) {
            colaConCuenta.enqueue(cliente);
        } else {
            colaSinCuenta.enqueue(cliente);
        }
    }

    public void procesarClientes() {
        for (int i = 0; i < cajas.length; i++) {
            if (!cajas[i].estaOcupada()) {
                Cliente cliente = null;
                if (!colaConCuenta.isEmpty()) {
                    cliente = (Cliente) colaConCuenta.dequeue();
                } else if (!colaSinCuenta.isEmpty()) {
                    cliente = (Cliente) colaSinCuenta.dequeue();
                }

                if (cliente != null) {
                    cajas[i].setOcupada(true);
                    if (cliente.isOperacion()) { // Depósito
                        System.out.println("Cliente en caja " + (i + 1) + " realiza depósito de: " + cliente.getMonto());
                        cajas[i].depositar(cliente.getMonto(), 100); // Simulación de denominación
                        montoTotal += cliente.getMonto();
                    } else { // Retiro
                        if (montoTotal >= cliente.getMonto()) {
                            System.out.println("Cliente en caja " + (i + 1) + " retira: " + cliente.getMonto());
                            cajas[i].retirar(cliente.getMonto());
                            montoTotal -= cliente.getMonto();
                        } else {
                            System.out.println("Fondos insuficientes en el banco.");
                        }
                    }
                    cajas[i].setOcupada(false);
                }
            }
        }
    }

    public void ingresarDineroCaja(int numeroCaja, double monto, double denominacion) {
        if (numeroCaja >= 1 && numeroCaja <= 4) {
            cajas[numeroCaja - 1].depositar(monto, denominacion);
            montoTotal += monto;
        }
    }

    public void mostrarEstadoCajas() {
        for (int i = 0; i < cajas.length; i++) {
            System.out.println("Caja " + (i + 1) + ":");
            cajas[i].mostrarDineroEnCaja();
        }
        System.out.println("Monto total en el banco: " + montoTotal);
    }

    public void mostrarMontoTotal() {
        System.out.println("Monto total en el banco: " + montoTotal);
    }
}
