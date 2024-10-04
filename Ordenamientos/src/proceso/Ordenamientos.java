package proceso;
//Clase que contiene los tres métodos de ordenamiento
public class Ordenamientos {
 public void ordenarBurbuja(int[] arr) {
     int n = arr.length;
     for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
             if (arr[j] > arr[j + 1]) {
                 int temp = arr[j];
                 arr[j] = arr[j + 1];
                 arr[j + 1] = temp;
             }
         }
     }
 }

 public void ordenarSeleccion(int[] arr) {
     int n = arr.length;
     for (int i = 0; i < n - 1; i++) {
         int indiceMin = i;
         for (int j = i + 1; j < n; j++) {
             if (arr[j] < arr[indiceMin]) {
                 indiceMin = j;
             }
         }
         int temp = arr[indiceMin];
         arr[indiceMin] = arr[i];
         arr[i] = temp;
     }
 }

 public void ordenarInsercion(int[] arr) {
     int n = arr.length;
     for (int i = 1; i < n; ++i) {
         int key = arr[i];
         int j = i - 1;
         while (j >= 0 && arr[j] > key) {
             arr[j + 1] = arr[j];
             j = j - 1;
         }
         arr[j + 1] = key;
     }
 }
}


