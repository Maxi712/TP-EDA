
package tpfinaleda;

import java.util.Scanner;
import static tpfinaleda.Algoritmos.bubbleSort;
import static tpfinaleda.Algoritmos.mergeSort;
import static tpfinaleda.Algoritmos.insertionSort;

public class TPfinalEDA {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //definimos un volumen masivo (puede ir variando este numero)
        //ojo: para Bubble Sort usar un numero mas chico (ej. 50000) o va a tardar horas.
        //para Merge Sort se banca 1.000.000 de sobra.
        int tamañoDatos = 50000;
        System.out.println("--- PREPARANDO DATOS ---");
        Video[] datosOriginales = generarDatosMasivos(tamañoDatos);
        
        //clonamos los arreglos para que ambos algoritmos compitan con los mismos datos exactos
        Video[] datosParaBubble = datosOriginales.clone();
        Video[] datosParaMerge = datosOriginales.clone();
        Video[] datosParaInsertion = datosOriginales.clone();
        System.out.println("Datos cargados. Tamaño del arreglo: " +tamañoDatos);
        System.out.println("======================================================");
        System.out.println("¡PAUSA! Abrimos VisualVM, buscamos este proceso y conectamos.");
        System.out.println("Cuando el monitoreo de VisualVM este activo, presionamos ENTER para arrancar...");
        teclado.nextLine(); //detiene el programa hasta que presionemos Enter
        
        Runtime rt = Runtime.getRuntime();
        
        //PRUEBA 1: BUBBLE SORT (Fuerza Bruta)
        System.out.println("Ejecutando Bubble Sort...");
        rt.gc(); // Limpiamos basura antes de medir
        long memAntesBubble = rt.totalMemory() - rt.freeMemory();
        long inicioBubble = System.currentTimeMillis();
        bubbleSort(datosParaBubble);
        long finBubble = System.currentTimeMillis();
        long memDespuesBubble = rt.totalMemory() - rt.freeMemory();
        System.out.println("Bubble Sort finalizado en: " +(finBubble - inicioBubble)+ " ms.");
        System.out.println("Memoria extra usada por Bubble Sort: " + ((memDespuesBubble - memAntesBubble) / 1024) + " KB");
        System.out.println("-----------------------------------------------------------");
        
/*         //PRUEBA 2: INSERTION SORT
        System.out.println("Ejecutando Insertion Sort...");
        rt.gc(); // Limpiamos basura antes de medir
        long memAntesInsertion = rt.totalMemory() - rt.freeMemory();
        long inicioInsertion = System.currentTimeMillis();
        insertionSort(datosParaInsertion);
        long finInsertion = System.currentTimeMillis();
        long memDespuesInsertion = rt.totalMemory() - rt.freeMemory();
        System.out.println("Insertion Sort finalizado en: " +(finInsertion - inicioInsertion)+ " ms.");
        System.out.println("Memoria extra usada por Insertion Sort: " + ((memDespuesInsertion - memAntesInsertion) / 1024) + " KB");
        System.out.println("-----------------------------------------------------------"); */
        
        //PRUEBA 3: MERGE SORT (Eficiente)
        System.out.println("Ejecutando Merge Sort...");
        rt.gc(); // Limpiamos basura antes de medir
        long memAntesMerge = rt.totalMemory() - rt.freeMemory();
        long inicioMerge = System.currentTimeMillis();
        mergeSort(datosParaMerge, 0, datosParaMerge.length - 1);
        long finMerge = System.currentTimeMillis();
        long memDespuesMerge = rt.totalMemory() - rt.freeMemory();
        System.out.println("Merge Sort finalizado en: " +(finMerge - inicioMerge)+ " ms.");
        System.out.println("Memoria extra usada por Merge Sort: " + ((memDespuesMerge - memAntesMerge) / 1024) + " KB");
        System.out.println("========================================================");
        System.out.println("Algoritmos completados. Revisar graficas en VisualVM.");
        System.out.println("Presionen ENTER una ultima vez para cerrar el programa...");
        teclado.nextLine();
        
        /*Video[]lv={
           new Video("v1",1080,5000, 2),
           new Video("v2",2160,7000, 6),
           new Video("v3",720,3000, 4),
           new Video("VideoD", 480, 1200, 1)
       };
       
       mergeSort(lv,0,lv.length-1);
       for(Video v: lv){
           System.out.println(v);
       }*/   
    }
    public static Video[] generarDatosMasivos(int cantidad){
        Video[] listaVideos = new Video[cantidad];
        
        //llenamos el arreglo ya ordenado de forma ascendente por sus bits
        for(int i = 0; i < cantidad; i++){
            //ponemos bits proporcionales a 'i' para que ya esten ordenados
            int bitsSimulados = i * 10;
            listaVideos[i] = new Video("Video_" + i, 1080, bitsSimulados, 2);
        }
        
        //desordenamos un pequeño porcentaje (ej. 5%) para simular la realidad
        int elementosADesordenar = (int) (cantidad * 0.10);
        java.util.Random rand = new java.util.Random();
        
        for(int k = 0; k < elementosADesordenar; k++){
            int indice1 = rand.nextInt(cantidad);
            int indice2 = rand.nextInt(cantidad);
            
            //intercambiamos posiciones
            listaVideos[indice1] = listaVideos[indice2];
            listaVideos[indice2] = listaVideos[indice1];
        }
    return listaVideos;
    }
}
