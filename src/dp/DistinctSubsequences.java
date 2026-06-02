package dp;

import java.util.Arrays;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 * rabbbit
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int [][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <=n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }


// Another approach

    int[][] dp;
    public int numDistinct2(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int [] arr : dp) Arrays.fill(arr, -1);

        return dfs(0,0, s, t);
    }

    public int dfs(int i, int j, String s, String t) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j]!=-1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i+1, j+1, s, t) + dfs(i+1, j, s, t);
        } else {
            dp[i][j] = dfs(i+1, j, s, t);
        }
        return dp[i][j];
    }
}
