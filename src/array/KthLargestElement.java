package array;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.remove();
    }
    public static void main(String arg[]) {
        int arr[] = {3,2,3,1,2,4,5,5,5,6};
        int k =4;
        System.out.println(findKthLargest(arr, k));
    }
}
