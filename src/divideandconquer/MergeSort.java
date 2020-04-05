package divideandconquer;

/**
 * Used divide and conquer
 */
public class MergeSort {

    public static void merge(int theArray[] ,int []workSpace, int lowPtr,
                             int highPtr, int upperBound) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; // # of items
        while(lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }

        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];

    }

    public static void recMergeSort(int arr[], int nums[], int l, int h){


        if(l<h){
            int mid = (l+h)/2;
            recMergeSort(arr,nums, l, mid);
            recMergeSort(arr,nums, mid+1, h);
            merge(arr,nums,l,mid+1,h);

        }
    }

    public static void mergeSort(int arr[]){
        int l = 0;
        int r = arr.length-1;
        int nums[] = new int[arr.length];
        recMergeSort(arr, nums, l, r);

    }

    public static void  main(String arg[]){

        int arr[] ={64,21,33, 70, 12, 85, 44, 3, 99, 0, 108, 36};
        mergeSort(arr);

        for (int i: arr) {
            System.out.println(i);
        }
    }
}
