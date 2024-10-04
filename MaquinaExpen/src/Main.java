import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine maquina = new VendingMachine();

        // Agregar productos iniciales
        maquina.agregarProducto(new Producto("A1", "Agua", 10.0));
        maquina.agregarProducto(new Producto("A2", "Refresco", 15.0));
        maquina.agregarProducto(new Producto("A3", "Papas", 20.0));
        maquina.agregarProducto(new Producto("A4", "Chocolate", 12.0));

        // Agregar monedas iniciales
        maquina.agregarMoneda(10, 5);  // 5 monedas de 10
        maquina.agregarMoneda(5, 5);   // 5 monedas de 5
        maquina.agregarMoneda(2, 5);   // 5 monedas de 2
        maquina.agregarMoneda(1, 5);   // 5 monedas de 1
        maquina.agregarMoneda(0.50, 5);// 5 monedas de 0.50

        while (true) {
            System.out.println("\nMáquina expendedora:");
            System.out.println("1. Ver productos");
            System.out.println("2. Comprar producto");
            System.out.println("3. Ver estado de la máquina");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Ver productos disponibles
                    maquina.imprimirEstadoProductos();
                    break;

                case 2:
                    // Comprar producto
                    System.out.print("Ingresa el código del producto que deseas comprar: ");
                    String codigo = scanner.next();

                    Producto producto = maquina.buscarProducto(codigo);
                    if (producto == null) {
                        System.out.println("Producto no disponible.");
                        break;
                    }

                    System.out.println("Has seleccionado: " + producto.getDescripcion() + " - Precio: " + producto.getPrecio());
                    double totalInsertado = 0;
                    double[] monedasInsertadas = new double[15]; // Límite de 15 monedas por compra
                    int indiceMoneda = 0;

                    while (totalInsertado < producto.getPrecio()) {
                        System.out.println("Total insertado: " + totalInsertado + " / " + producto.getPrecio());
                        System.out.println("Inserta moneda (10, 5, 2, 1, 0.5): ");
                        double moneda = scanner.nextDouble();

                        if (!maquina.agregarMoneda(moneda, 1)) {
                            System.out.println("No se puede agregar más monedas de esta denominación.");
                        } else {
                            monedasInsertadas[indiceMoneda++] = moneda;
                            totalInsertado += moneda;
                        }

                        if (totalInsertado >= producto.getPrecio()) {
                            break;
                        }
                    }

                    Producto comprado = maquina.comprarProducto(codigo, monedasInsertadas);
                    if (comprado != null) {
                        System.out.println("Producto comprado: " + comprado.getDescripcion());
                    } else {
                        System.out.println("No se pudo realizar la compra.");
                    }
                    break;

                case 3:
                    // Ver estado de la máquina
                    maquina.imprimirEstado();
                    break;

                case 4:
                    // Salir del programa
                    System.out.println("Gracias por usar la máquina expendedora.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}

