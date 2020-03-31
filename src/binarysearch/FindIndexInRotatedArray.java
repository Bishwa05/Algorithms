package binarysearch;

/**
 * Time complexity O(logn)
 * If element found return the index of the element or return -1
 */
public class FindIndexInRotatedArray {

    public static int findIndex(int arr[], int val) {
        int smallestNumberIndex = -1;
        int n = arr.length;

        int l =0; int r = n-1;

        while(l<=r) {
            int mid = l+ (r-l)/2;
            if(arr[mid] > arr[n-1]){
                l= mid+1;
            } else{
                smallestNumberIndex = mid;
                r =  mid-1;
            }
        }

        l =0;
        r = n-1;

        while(l<=r) {
            int mid = l +(r-l)/2;
            int newIndex = (mid + smallestNumberIndex)%n;

            if(arr[newIndex]< val){
                l = mid+1;
            } else if(arr[newIndex]> val) {
                r = mid-1;
            } else{
                return newIndex;
            }
        }
        return -1;
    }

    public static void main(String arg[]) {
        int arr[] = {4,5,7,8,1,2,3};

        System.out.println(findIndex(arr, 2));
    }
}
