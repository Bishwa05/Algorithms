package array;

/**
 * Kedane's Algorithm
 */
public class MaximumSubArraySum
{
    public static int maxSubArraySum(int[] nums){
        int maxEndHere = nums[0];
        int maxSoFar = nums[0];

        for(int i =1; i<nums.length; i++){
            int num = nums[i];
            maxEndHere = Math.max(num, maxEndHere+num);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }

    public static void main(String arg[]){
        int []nums= {-1,3, 4, -5, 7, 2, -9, 4};

        MaximumSubArraySum m = new MaximumSubArraySum();
        System.out.println(m.maxSubArraySum(nums));
    }

}
