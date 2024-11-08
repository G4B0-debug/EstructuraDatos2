import java.util.Random;

public class Ejercicio_3 {

    public static void main(String[] args) {
  
        Queues.CircularQueue queue = new Queues().new CircularQueue(50);

       
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            queue.enqueue(random.nextInt(50) + 1);
        }


        System.out.println("Elementos en la cola: " + queue);

       
        ArrayList ElementosUnicos = getElementosUnicos(queue);

       
        System.out.println("Números únicos: " + ElementosUnicos);
    }

  
    public static ArrayList getElementosUnicos(Queues.CircularQueue queue) {
        ArrayList Elementosunicos = new ArrayList();
        int[] counts = new int[51]; 
 
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            int number = (int) queue.dequeue();
            counts[number]++;
            queue.enqueue(number);
        }

        
        for (int i = 1; i <= 50; i++) {
            if (counts[i] == 1) {
                Elementosunicos.add(i);
            }
        }

        return Elementosunicos;
    }


    public static class Queues {

        public class CircularQueue {
            private int f;
            private int r;
            private Object[] queue;
            private int size;

            public CircularQueue(int size) {
                f = 0;
                r = 0;
                queue = new Object[size];
                this.size = 0;
            }

            public int size() {
                return size;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull() {
                return size == queue.length;
            }

            public void enqueue(Object value) {
                if (!isFull()) {
                    queue[f] = value;
                    f = (f + 1) % queue.length;
                    size++;
                }
            }

            public Object dequeue() {
                Object valor = null;
                if (!isEmpty()) {
                    valor = queue[r];
                    queue[r] = null;
                    r = (r + 1) % queue.length;
                    size--;
                }
                return valor;
            }

            @Override
            public String toString() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < size; i++) {
                    int tempI = (i + r) % queue.length;
                    s.append(queue[tempI]).append(" > ");
                }
                return s.toString();
            }
        }
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

        public void add(Object value) {
            if (size == list.length) {
                incrementa();
            }
            list[size] = value;
            size++;
        }

        private void incrementa() {
            Object[] tempList = new Object[list.length + increment];
            System.arraycopy(list, 0, tempList, 0, list.length);
            list = tempList;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < size; i++) {
                s.append(list[i]).append(", ");
            }
            return s.length() > 0 ? s.substring(0, s.length() - 2) : s.toString();
        }
    }
}

