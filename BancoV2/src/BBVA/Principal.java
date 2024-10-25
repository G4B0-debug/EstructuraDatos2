package BBVA;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double montoInicial = 600000;
        Banco banco = new Banco(montoInicial);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar persona (Cuenta / No Cuenta)");
            System.out.println("2. Ingreso caja");
            System.out.println("3. Ingresar Dinero a Caja");
            System.out.println("4. Ver estado del Banco");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cliente tiene cuenta? (1: Sí, 0: No):");
                    boolean tieneCuenta = scanner.nextInt() == 1;
                    System.out.println("Ingrese monto:");
                    double monto = scanner.nextDouble();
                    System.out.println("Ingrese tipo de operación (1 para depósito, 0 para retiro):");
                    boolean operacion = scanner.nextInt() == 1;
                    String tipoCliente = tieneCuenta ? "conCuenta" : "sinCuenta";
                    String numeroCuenta = tieneCuenta ? "042" : "";  // Ejemplo de cuenta prioritaria
                    banco.agregarCliente(new Cliente(tipoCliente, operacion, monto, numeroCuenta));
                    break;
                case 2:
                    banco.procesarClientes();
                    break;
                case 3:
                    System.out.println("Ingrese número de caja, monto y denominación:");
                    int numeroCaja = scanner.nextInt();
                    double montoDeposito = scanner.nextDouble();
                    double denominacion = scanner.nextDouble();
                    banco.ingresarDineroCaja(numeroCaja, montoDeposito, denominacion);
                    break;
                case 4:
                    banco.mostrarEstadoCajas();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}

