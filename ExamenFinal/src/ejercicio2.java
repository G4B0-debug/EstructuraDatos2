import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        ArrayList palabras = new ArrayList();
        ArrayList palabrasDesechas = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Escribir palabra");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Imprimir palabras");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Escribe una palabra: ");
                    String nuevaPalabra = scanner.nextLine();
                    palabras.add(nuevaPalabra);
                    palabrasDesechas = new ArrayList(); 
                    break;
                case 2:
                    if (!palabras.isEmpty()) {
                        Object ultimaPalabra = palabras.remove(palabras.size() - 1);
                        palabrasDesechas.add(ultimaPalabra);
                        System.out.println("Se deshizo la última palabra.");
                    } else {
                        System.out.println("No hay palabras para deshacer.");
                    }
                    break;
                case 3:
                    if (!palabrasDesechas.isEmpty()) {
                        Object palabraRehacer = palabrasDesechas.remove(palabrasDesechas.size() - 1);
                        palabras.add(palabraRehacer);
                        System.out.println("Se rehizo la última palabra deshecha.");
                    } else {
                        System.out.println("No hay palabras para rehacer.");
                    }
                    break;
                case 4:
                    System.out.println("Palabras actuales: " + palabras);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}

class ArrayList {
    private int size;
    private Object[] list;
    private int increment;

    public ArrayList() {
        this.size = 0;
        this.list = new Object[10];
        this.increment = 10;
    }

    public ArrayList(int intSize) {
        this.size = 0;
        this.list = new Object[intSize];
        this.increment = 10;
    }

    public ArrayList(int intSize, int increment) {
        this.size = 0;
        this.list = new Object[intSize];
        this.increment = increment;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object value) {
        list[size] = value;
        size++;

        if (size == list.length) {
            incrementa();
        }
    }

    private void incrementa() {
        Object[] tempList = new Object[list.length + increment];
        for (int i = 0; i < list.length; i++) {
            tempList[i] = list[i];
        }
        list = tempList;
    }

    public void add(int index, Object value) {
        if (size == index) {
            add(value);
        } else if (index < size) {
            for (int i = size; i >= index; i--) {
                list[i + 1] = list[i];
            }

            list[index] = value;
            size++;
            if (size == list.length) {
                incrementa();
            }
        }
    }

    public Object remove(int index) {
        Object value = null;
        if (size == index && !isEmpty()) {
            value = list[index];
            list[index] = null;
            size--;
        } else if (index < size && index >= 0) {
            value = list[index];
            for (int i = index + 1; i < size; i++) {
                list[i - 1] = list[i];
            }
            list[size] = null;
            size--;
        }
        return value;
    }

    public Object get(int index) {
        Object value = null;
        if (index >= 0 && index < size && !isEmpty()) {
            value = list[index];
        }
        return value;
    }

    public Object set(int index, Object value) {
        Object returnVal = null;

        if (index >= 0 && index < size && !isEmpty()) {
            returnVal = list[index];
            list[index] = value;
        }
        return returnVal;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += list[i] + " ";
        }
        return s;
    }
}
