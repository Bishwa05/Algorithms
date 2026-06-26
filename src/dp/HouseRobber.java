package dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i]+ dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }

    // Approach 2
    public int rob2(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return max;
    }
}
