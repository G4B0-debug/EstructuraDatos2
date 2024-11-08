import java.util.Random;

public class Ejercicio_1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Random random = new Random();

   
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(100) + 1);
        }

 
        System.out.println("Números generados: " + list);

        
        System.out.println("Media Aritmética: " + calcularMedia(list));
        System.out.println("Moda: " + calcularModa(list));
        System.out.println("Mediana: " );
    }

    public static double calcularMedia(ArrayList list) {
        double suma = 0;
        for (int i = 0; i < list.size(); i++) {
            suma += (int) list.get(i);
        }
        return suma / list.size();
    }

    public static int calcularModa(ArrayList list) {
        int moda = -1;
        int maxFrecuencia = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = (int) list.get(i);
            int frecuencia = 0;
        for (int j = 0; j < list.size(); j++) {
                if ((int) list.get(j) == num) {
                    frecuencia++;
                }
            }

          
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = num;
            }
        }
        return moda;
    }



    public static class ArrayList {
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
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < size; i++) {
                s.append(list[i]).append(", ");
            }
            return s.toString();
        }
    }
}
