package modified_binary_search;

public class MinimumDifferenceElement {
    public int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0]) return arr[0];
        if (key > arr[arr.length-1]) return arr[arr.length -1];

        int start = 0, end = arr.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (key < arr[mid]) {
                end = mid -1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }

        // at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array
        // return the element which is closest to the 'key'
        if ((arr[start] - key) < (key - arr[end])) {
            return arr[start];
        } else {
            return arr[end];
        }
    }
}
