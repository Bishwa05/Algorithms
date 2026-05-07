package modified_binary_search;

public class NumberRange {
    public int[] findRange(int[] arr, int key) {
        int[] res = new int[] {-1, -1};
        res[0] =  search(arr, key, false);

        if (res[0]!= -1) {
            res[1] =  search(arr, key, true);
        }

        return res;
    }

    private static int search(int[] arr, int key, boolean findMaxIndex) {

        int low = 0, high = arr.length -1;
        int keyIndex = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid]> key) high = mid - 1;
            else if (arr[mid] < key) low = mid +1;
            else {
                keyIndex = mid;
                if (findMaxIndex) {
                    low = mid +1;  // search ahead to find the last index of 'key'
                } else {
                    high = mid - 1; // search behind to find the first index of 'key'
                }
            }
        }
        return keyIndex;
    }
}
