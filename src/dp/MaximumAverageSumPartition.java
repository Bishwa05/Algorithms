package dp;

/**
 *
 * Input : A = { 9, 1, 2, 3, 9 }
 * K = 3
 * Output : 20
 * Explanation : We can partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9]. That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 *
 * Input : A[] = { 1, 2, 3, 4, 5, 6, 7 }
 * K = 4
 * Output : 20.5
 * Explanation : We can partition A into [1, 2, 3, 4], [5], [6], [7]. The answer is 2.5 + 5 + 6 + 7 = 20.5.
 *
 *
 *
 */
public class MaximumAverageSumPartition
{

    public double maxAvgSumPartition(int[] nums, int k){
        int n = nums.length;
        double sum =0;
        double[][] dp = new double[n+1][k+1];
        for(int i=0; i< n; i++){
            sum+=nums[i];
            dp[i+1][1] = sum/(i+1);
        }

        return score(n, nums, k, dp);
    }

    public double score(int n, int []nums, int k, double[][] dp){

        if(dp[n][k]>0) return dp[n][k];

        double sum =0;
        for(int i = n-1; i>0; i--) {
            sum += nums[i];

            dp[n][k] = Math.max(dp[n][k], score(i, nums, k - 1, dp) + sum / (n - i));
        }
        return dp[n][k];
    }

    public static void main(String arg[]){
        MaximumAverageSumPartition m = new MaximumAverageSumPartition();
        int []nums = { 9, 1, 2, 3, 9 };

        System.out.println(m.maxAvgSumPartition(nums, 3));
    }
}
