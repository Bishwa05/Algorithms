package dp;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */
public class MinCostClimbingStairs
{

    public static int minCostClimbingStairs (int[] cost)
    {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == n ? 0 : cost[i]);
        }
        return dp[n];
    }

    // Approach 2
    public static int minCostClimbingStairs2 (int[] cost){
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(cost[i], cost[i-1]) + cost[i];
            first = second;
            second = current;
        }

        // Minimum cost to reach last step or one step past it
        return Math.min(first, second);
    }

    public static void main (String arg[])
    {
        int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(minCostClimbingStairs(arr));

    }
}
