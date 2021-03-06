package dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs
{

    /**
     * Time limit exceeded in this approach in leetcode.
     * Time complexity O(2^(n+n/2))
     */
    public int climbStairs (int n)
    {
        return helper(0, n, 0);

    }

    public int helper (int i, int n, int count)
    {

        if (i == n) {
            count = count + 1;
            return count;
        }
        if (i > n) {
            return count;
        }

        return helper(i + 1, n, count) + helper(i + 2, n, count);

    }

    /**
     * In this approach the time complexity O(2n) = O(n).
     */
    public int climbStairsDP (int n)
    {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int stair = 2; stair <= n; ++stair) {
            for (int step = 1; step <= 2; ++step) {
                dp[stair] += dp[stair - step];
            }
        }
        return dp[n];
    }

    public static void main (String arg[])
    {
        ClimbingStairs c = new ClimbingStairs();
        int n = 44;
        System.out.println(c.climbStairs(n));
        System.out.println(c.climbStairsDP(n));
    }
}
