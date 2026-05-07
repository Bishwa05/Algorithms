package modified_binary_search;

/***
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.
 *
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 *
 * Example 1:
 *
 * Input: [4, 6, 10], key = 10
 * Output: 2
 *
 */
public class OrderAgnosticBinarySearch {
    public int search(int[] arr, int key) {
        int i = 0;
        int j = arr.length -1;
        if (arr[i] < arr[j]) {
            while (i <= j) {
                int mid = i + (j -i)/2;
                if (arr[mid] == key) return mid;
                else if (arr[mid]> key) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            while (i <= j) {
                int mid = i + (j -i)/2;
                if (arr[mid] == key) return mid;
                else if (arr[mid]> key) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return -1; // element not found
    }
}
