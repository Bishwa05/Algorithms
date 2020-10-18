package sorting;

/**
 *
 * 1. Since the tree satisfies Max-Heap property, then the largest item is stored at the root node.
 * 2. Swap: Remove the root element and put at the end of the array (nth position) Put the last item of the tree (heap) at the vacant place.
 * 3. Remove: Reduce the size of the heap by 1.
 * 4. Heapify: Heapify the root element again so that we have the highest element at root.
 * 5. The process is repeated until all the items of the list are sorted.
 *
 *
 */
public class HeapSort
{

    public void sort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String arg[]){
        HeapSort hs = new HeapSort();
        int arr[] = {-1,8, 6, 9, -3, 7,3, 2,4};
        hs.sort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
