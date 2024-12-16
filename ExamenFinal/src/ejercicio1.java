import java.util.Random;
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        ArrayList claves = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Generar 10 claves aleatorias");
            System.out.println("2. Mostrar claves ordenadas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarClavesAleatorias(claves);
                    System.out.println("Se han generado 10 claves aleatorias.");
                    break;
                case 2:
                    mostrarClavesOrdenadas(claves);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void generarClavesAleatorias(ArrayList claves) {
        Random random = new Random();
        while (claves.size() > 0) {
            claves.remove(0);
        }

        for (int i = 0; i < 10; i++) {
            int año = 1990 + random.nextInt(18); 
            int numeroLibro = random.nextInt(10000); 
            String clave = "ISBN-" + año + "-" + ("0000" + numeroLibro).substring(("" + numeroLibro).length());
            claves.add(clave);
        }
    }

    private static void mostrarClavesOrdenadas(ArrayList claves) {
        if (claves.size() == 0) {
            System.out.println("No hay claves generadas para mostrar.");
            return;
        }

        for (int i = 0; i < claves.size() - 1; i++) {
            for (int j = i + 1; j < claves.size(); j++) {
                String[] partes1 = ((String) claves.get(i)).split("-");
                String[] partes2 = ((String) claves.get(j)).split("-");
                int año1 = Integer.parseInt(partes1[1]);
                int año2 = Integer.parseInt(partes2[1]);
                int num1 = Integer.parseInt(partes1[2]);
                int num2 = Integer.parseInt(partes2[2]);

                if (año1 > año2 || (año1 == año2 && num1 > num2)) {
                    Object temp = claves.get(i);
                    claves.set(i, claves.get(j));
                    claves.set(j, temp);
                }
            }
        }

        System.out.println("\nClaves ordenadas:");
        for (int i = 0; i < claves.size(); i++) {
            System.out.println(claves.get(i));
        }
    }

    static class ArrayList {
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
}
