package dp;

import java.util.Arrays;

/**
 *
 * The isSubsetSum problem can be divided into two subproblems
 *  a) isSubsetSum() without considering last element
 *     (reducing n to n-1)
 *  b) isSubsetSum considering the last element
 *     (reducing sum/2 by arr[n-1] and n to n-1)
 * If any of the above the above subproblems return true, then return true.
 * isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
 *                               isSubsetSum (arr, n-1, sum/2 - arr[n-1])
 *
 *
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
        }

        if((sum % 2)!=0) return false;

        return isSubsetSum(nums, nums.length, sum/2);
    }

    public boolean isSubsetSum(int[] nums, int n, int sum){
        if(sum==0) return true;

        if(n ==0 && sum != 0) return false;

        if(nums[n-1] > sum)
            return isSubsetSum(nums, n-1, sum);

        return isSubsetSum(nums, n-1, sum) ||
            isSubsetSum(nums, n, sum- nums[n-1]);
    }


    public boolean canPartitionDP(int[] nums) {

        int sum =0;
        for(int i : nums){
            sum+=i;
        }

        if(sum%2 !=0) return false;
        Arrays.sort(nums);
        int half = sum/2;

        boolean[][] dp = new boolean[nums.length+1][half+1];
        dp[0][0] = true;
        for(int i=1; i<=nums.length; i++) {
            for(int j=1; j<=half; j++) {
                dp[i][j] = dp[i-1][j] || (j >=nums[i-1] && dp[i-1][j-nums[i-1]]);
            }
        }
        return dp[nums.length][half];

        /**
         * boolean[] dp = new boolean[half+1];
         *         dp[0] = true;
         *         for(int i=1; i<=nums.length; i++) {
         *             for(int j=target; j >=0 ;j--) {
         *                 dp[j] = dp[j] || (j >=nums[i-1] && dp[j-nums[i-1]]);
         *             }
         *         }
         *         return dp[half];
         */
    }

    public static void main(String arg[]) {
        int[] n = {1,2,3,4,5,6,7};
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartitionDP(n));

    }
}
