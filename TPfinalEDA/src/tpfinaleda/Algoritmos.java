
package tpfinaleda;


public class Algoritmos {
    public static void mergeSort(Video[] arr, int left, int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }
    }
    
    public static void merge(Video[] arr, int left, int mid, int right){
        int n1=mid-left+1;
        int n2=right-mid;
        Video[] l=new Video[n1];
        Video[] r=new Video[n2];
        
        for(int i=0; i<n1; i++){
            l[i]=arr[left+i];
        } 
        for(int j=0; j<n2; j++){
            r[j]=arr[mid+1+j];
        } 
        int i=0;
        int j=0;
        int k=left;
        
        while(i<n1 && j<n2){
            if(l[i].bits>=r[j].bits){
                arr[k++]=l[i++];
            }else{
                arr[k++]=r[j++];
            }
        }
        while(i<n1){
            arr[k++]=l[i++];
        }
        while(j<n2){
            arr[k++]=r[j++];
        }
        
    }

    public static void bubbleSort(Video[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
            //comparamos el atributo 'bits' (fuera bruta)
            if(arr[j].bits > arr[j + 1].bits){
                //intercambio (sawp)
                Video temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
}