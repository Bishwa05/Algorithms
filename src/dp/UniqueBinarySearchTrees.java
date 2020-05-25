package dp;

/**
 *  I think this is implementation of catalan number.
 *  TODO: More analysis needed.
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int l = 2; l <= n; l++)
        {
            for(int i = 0; i < l; i++)
                dp[l] += (dp[i] * dp[l - i - 1]);
        }
        return dp[n];
    }
}
