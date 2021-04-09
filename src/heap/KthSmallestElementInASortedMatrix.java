package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix
{
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                pq.add(matrix[i][j]);
            }
        }

        for(int i =0; i<k-1 && i< m*n; i++){
            int x = pq.poll();
            //System.out.println(x);
        }
        return pq.peek();

    }

    public int kthSmallest2(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);             //for creating a max heap.
        // Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // We can use this inbuilt function to create max heap.
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if(pq.size()>k)
                    pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     *
     * Binary search
     */
    public int kthSmallestBS(int[][] matrix, int k){
        int smallest = matrix[0][0];
        int largest = matrix[matrix.length-1][matrix[0].length-1];

        while(smallest < largest){
            int mid = smallest +(largest-smallest)/2;
            if(getNumberOfElementsSmallerThanMid(matrix, mid)>=k){
                largest = mid;
            } else {
                smallest = mid +1;
            }
        }
        return smallest;
    }

    private int getNumberOfElementsSmallerThanMid(int[][]matrix, int target){
        int count = 0;
        int i =0;
        int j = matrix.length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] <= target){
                count = count +j+1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }


    public static void main(String arg[]){
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        KthSmallestElementInASortedMatrix f = new KthSmallestElementInASortedMatrix();
        System.out.println(f.kthSmallestBS(matrix, 8));
    }
}
