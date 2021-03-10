package sorting;

/**
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 *
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 */
public class CyclicSort
{

    public void sort(int[] arr) {
        int i =0;
        while(i<arr.length) {
            if(arr[i]!= arr[arr[i]-1]){
                swap(arr, arr[i], arr[arr[i]-1]);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
