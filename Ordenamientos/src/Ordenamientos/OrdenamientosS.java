package Ordenamientos;

import proceso.Ordenamientos;

//Clase Principal para probar los ordenamientos
public class OrdenamientosS{
public static void main(String[] args) {
   int[] arrBurbuja = {64, 34, 25, 12, 22, 11, 90};
   int[] arrSeleccion = arrBurbuja.clone();
   int[] arrInsercion = arrBurbuja.clone();

   // Crear una instancia de la clase Ordenamientos
   Ordenamientos ordenamientos = new Ordenamientos();

   // Ordenamiento Burbuja
   ordenamientos.ordenarBurbuja(arrBurbuja);
   System.out.println("Ordenamiento Burbuja:");
   for (int num : arrBurbuja) {
       System.out.print(num + " ");
   }
   System.out.println();

   // Ordenamiento Selección
   ordenamientos.ordenarSeleccion(arrSeleccion);
   System.out.println("Ordenamiento Selección:");
   for (int num : arrSeleccion) {
       System.out.print(num + " ");
   }
   System.out.println();

   // Ordenamiento Inserción
   ordenamientos.ordenarInsercion(arrInsercion);
   System.out.println("Ordenamiento Inserción:");
   for (int num : arrInsercion) {
       System.out.print(num + " ");
   }
   System.out.println();
}
}
  

