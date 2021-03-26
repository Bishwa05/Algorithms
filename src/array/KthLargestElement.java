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

    /**
     * Another good approach
     */

    public int findKthLargest2(int[] nums, int k) {
        k = nums.length -k;
       int low =0;
       int hi = nums.length -1;

       while(low<hi){
           int mid = partition(nums, low, hi);

           if(mid == k){
               break;
           } else if(mid<k){
               low = mid+1;
           } else{
               hi = mid -1;
           }
       }
        return nums[k];
    }


    private int partition(int[] nums, int l, int h){
        int p = nums[l];
        int i = l;
        int j = h;

        while(true){
            while(i<h && nums[i]<=p) i++;
            while(j>l && nums[j]>p) j--;

            if(i>=j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String arg[]) {
        int arr[] = {3,2,5,1,2,4,5,5,6,3};
        int k =3;
        // System.out.println(findKthLargest(arr, k));

        KthLargestElement l = new KthLargestElement();
        System.out.println(l.findKthLargest2(arr, k));
    }
}
