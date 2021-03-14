package dp;

public class MaxSubsetSumNoAdjacent
{

    public static int maxSubsetSumNoAdjacent (int[] nums)
    {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main (String arg[])
    {
        int[] nums = { 1, 3, 4, 2, 6, 5 };

        MaxSubsetSumNoAdjacent m = new MaxSubsetSumNoAdjacent();
        System.out.println(m.maxSubsetSumNoAdjacent(nums));
    }
}
