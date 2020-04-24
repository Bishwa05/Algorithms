package divideandconquer;

/**
 * Used divide and conquer
 */
public class MergeSort {

    public static void merge(int arr[] , int start,
                             int mid, int end) {
        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k += 1;
                i += 1;
            }
            else {
                temp[k] = arr[j];
                k += 1;
                j += 1;
            }
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = arr[i];
            k += 1;
            i += 1;
        }

        // add elements left in the second interval
        while(j <= end) {
            temp[k] = arr[j];
            k += 1;
            j += 1;
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            arr[i] = temp[i - start];
        }
    }

    // arr is an array of integer type
    // start and end are the starting and ending index of current interval of arr

    public static void recMergeSort(int arr[], int l, int h){


        if(l<h){
            int mid = (l+h)/2;
            recMergeSort(arr, l, mid);
            recMergeSort(arr, mid+1, h);
            merge(arr,l,mid,h);

        }
    }

    public static void mergeSort(int arr[]){
        int l = 0;
        int r = arr.length-1;
        recMergeSort(arr, l, r);

    }

    public static void  main(String arg[]){

        int arr[] ={64,21,33, 70, 12, 85, 44, 3, 99, 0, 108, 36};
        mergeSort(arr);

        for (int i: arr) {
            System.out.println(i);
        }
    }
}
