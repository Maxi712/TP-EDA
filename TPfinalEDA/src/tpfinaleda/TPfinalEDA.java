
package tpfinaleda;

import static tpfinaleda.Algoritmos.mergeSort;



public class TPfinalEDA {

    public static void main(String[] args) {
       Video[]lv={
           new Video("v1",1080,5000, 2),
           new Video("v2",2160,7000, 6),
           new Video("v3",720,3000, 4),
           new Video("VideoD", 480, 1200, 1)
       };
       
       mergeSort(lv,0,lv.length-1);
       for(Video v: lv){
           System.out.println(v);
       }
       
    
        

        
    }
    
}
