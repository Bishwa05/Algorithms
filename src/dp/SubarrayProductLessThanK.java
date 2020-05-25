package dp;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <=1) return 0;
     int prod =1;
     int result =0;

     int left = 0;
     int right =0;

     while(right< nums.length){
         prod *= nums[right];

         while(prod>=k){
             prod = prod/nums[left];
             left++;

         }
         result += right -left+1;
         right++;

     }
     return result;
    }


    public static void main(String arg[]) {
        int arr[] = {10, 5, 2, 6};
        int k = 100;
        SubarrayProductLessThanK a = new  SubarrayProductLessThanK();
        System.out.println(a.numSubarrayProductLessThanK(arr, k));
    }
}
