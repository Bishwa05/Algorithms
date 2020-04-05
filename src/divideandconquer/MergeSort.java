package divideandconquer;

/**
 * Used divide and conquer
 */
public class MergeSort {

    public static void merge(int []arr, int l, int mid, int h) {

    }

    public static void recMergeSort(int arr[], int l, int h){


        if(l<h){
            int mid = (l+r)/2;
            recMergeSort(arr, l, mid);
            recMergeSort(arr, mid+1, h);
            merge(arr,l,mid+1,h);

        }
    }

    public static void mergeSort(int arr[]){
        int l = 0;
        int r = arr.length;
        recMergeSort(arr, l, r);

    }

    public static void  main(String arg[]){

        int arr[] ={64,21,33, 70, 12, 85, 44, 3, 99, 0, 108, 36};
        mergeSort(arr);
    }
}
