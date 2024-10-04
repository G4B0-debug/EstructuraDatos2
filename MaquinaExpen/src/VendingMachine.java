public class VendingMachine {
    private Producto[] productos;
    private Moneda[] monedas;
    private final int MAX_PRODUCTOS = 10;
    private final int MAX_MONEDAS = 15;

    // Para las colas circulares
    private Moneda[][] colasMonedas;
    private int[] front, rear, count;

    public VendingMachine() {
        productos = new Producto[MAX_PRODUCTOS];
        
        colasMonedas = new Moneda[5][MAX_MONEDAS]; 
        front = new int[5];  
        rear = new int[5];   
        count = new int[5];  

        for (int i = 0; i < 5; i++) {
            front[i] = 0;
            rear[i] = 0;
            count[i] = 0;
        }

        monedas = new Moneda[5];
        monedas[0] = new Moneda(10);
        monedas[1] = new Moneda(5);
        monedas[2] = new Moneda(2);
        monedas[3] = new Moneda(1);
        monedas[4] = new Moneda(0.50);
    }

    public boolean agregarProducto(Producto producto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = producto;
                return true;
            }
        }
        return false;
    }

    public boolean agregarMoneda(double valor, int cantidad) {
        int index = getMonedaIndex(valor);
        if (index != -1 && count[index] < MAX_MONEDAS) {
            for (int i = 0; i < cantidad; i++) {
                colasMonedas[index][rear[index]] = new Moneda(valor);
                rear[index] = (rear[index] + 1) % MAX_MONEDAS; 
                count[index]++;
            }
            return true;
        }
        return false;
    }

    public Producto comprarProducto(String codigo, double[] monedasInsertadas) {
        Producto producto = buscarProducto(codigo);
        if (producto == null) {
            System.out.println("Producto no disponible.");
            return null;
        }

        double totalInsertado = 0;
        for (double moneda : monedasInsertadas) {
            totalInsertado += moneda;
        }

        if (totalInsertado < producto.getPrecio()) {
            System.out.println("Dinero insuficiente.");
            return null;
        }

        double cambio = totalInsertado - producto.getPrecio();
        if (!validarCambio(cambio)) {
            System.out.println("No se puede dar el cambio.");
            return null;
        }

        eliminarProducto(codigo);
        devolverCambio(cambio);
        return producto;
    }

    private boolean validarCambio(double cambio) {
        return true;
    }

    private void devolverCambio(double cambio) {}

    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto != null && producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    private void eliminarProducto(String codigo) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCodigo().equals(codigo)) {
                productos[i] = null;
                break;
            }
        }
    }

    private int getMonedaIndex(double valor) {
        switch ((int) (valor * 10)) {
            case 100: return 0;
            case 50: return 1;
            case 20: return 2;
            case 10: return 3;
            case 5: return 4;
            default: return -1;
        }
    }

    public void imprimirEstadoProductos() {
        System.out.println("Estado de los productos:");
        for (Producto producto : productos) {
            if (producto != null) {
                System.out.println(producto);
            }
        }
    }

    public void imprimirEstado() {
        imprimirEstadoProductos();

        System.out.println("Estado de las monedas:");
        for (int i = 0; i < colasMonedas.length; i++) {
            System.out.println("Monedas de " + monedas[i].getValor() + ": " + count[i] + " unidades");
        }
    }
}
