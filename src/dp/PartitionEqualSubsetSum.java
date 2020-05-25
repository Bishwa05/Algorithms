package dp;

import java.util.Arrays;

/**
 * TODO: Analysis
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

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
        System.out.println(p.canPartition(n));

    }
}
