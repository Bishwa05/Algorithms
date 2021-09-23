package array;

/**
 * Whether array has continuously increasing or decreasing elements
 */
public class MonotonicArray
{

    public boolean isMonotonicArray(int[] arr) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i=1; i<arr.length; i++){
            if(arr[i]>arr[i-1]){
                isDecreasing = false;
            } else{
                isIncreasing = false;
            }
        }
        return isDecreasing || isIncreasing;
    }

    public static void main(String arg[]){
        //int[] arr = {-1, -3, -5, -7, -9};
        //int[] arr = {1, 3, 5, 7, 9};
        int[] arr = {1, 3, 5, 7, 6};
        MonotonicArray m = new MonotonicArray();
        System.out.println(m.isMonotonicArray(arr));
    }
}
