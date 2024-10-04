package BBVA;

import java.util.Scanner;

/*Funcionamiento del banco:
 * el funcionamiento del banco es el siguiente: 
 * primero el banco cuenta con 600,000 pesos como dinero inicial de los cuales el usuario distribuye una cantidad 
 * a cada caja (utilizando la opcion 4 del menu 
 * despues de distribuir las cantidades a las cajas
 * el usuario puede ingresar a las personas que desee repitiendo la opcion 1, la cual solicita si tiene cuenta 
 * señalado con el numero 1 o si no señalado con el numero 0
 * una vez seleccionado el tipo les pedira ingresar el monto y y tipo de operaacion 
 * siguiente a eso el usuario debera selccionar la opcion 2 para enviar a las personas a caja 
 * este seleccionara dependiendo la prioridad y procesarlos
 * una vez entren en caja el usuario selccionara la opcion numero 3 las cuales permetira procesar a los clientes en caja
 * de esa manera se liberara el espacio y podran continuar con las personas faltantes 
 * 
 * 
 * con la opcion numero 5 del menu podremos ver el estado del banco es decir la cantidad de dinero disponible en cada caja
 * si queremos ver las cajas ocupadas con la opcion numero 2 podemos revisar cuales estan ocupadas 

*/
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double montoInicial = 600000; // Monto inicial fijo
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
                    System.out.println("Ingrese monto y tipo de operación (1 para depósito, 0 para retiro):");
                    System.out.println("Ingrese monto :");
                    double monto = scanner.nextDouble();
                    System.out.println("tipo de operación:");
                    boolean operacion = scanner.nextInt() == 1;
                    String tipoCliente = tieneCuenta ? "conCuenta" : "sinCuenta";
                    banco.agregarCliente(new Cliente(tipoCliente, operacion, monto));
                    break;
                case 2:
                    banco.procesarClientes();
                    System.out.println("Clientes procesados. Psen los Siguientes"); //si al presionar esta opcion no aparece mas que el mensaje quiere decir que las cajas estan libres
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
