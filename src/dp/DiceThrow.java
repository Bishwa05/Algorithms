package dp;

/*
Given n dice each with m faces, numbered from 1 to m,
find the number of ways to get sum X.
X is the summation of values on each face when all the dice are thrown.

So we can recursively write Sum(m, n, x) as following
Sum(m, n, X) = Sum(m, n - 1, X - 1) +
               Sum(m, n - 1, X - 2) +
               .................... +
               Sum(m, n - 1, X - m)

 */

import java.util.Arrays;

public class DiceThrow
{
    static double mod = 1000000000 + 7;

    static long findWays (int m, int n, int x)
    {

    /* Create a table to store the results of subproblems.
    One extra row and column are used for simplicity
    (Number of dice is directly used as row index and sum is directly used as column index).
    The entries in 0th row and 0th column are never used. */
        long[][] table = new long[n + 1][x + 1];

        /* Table entries for only one dice */
        for (int j = 1; j <= m && j <= x; j++)
            table[1][j] = 1;

    /* Fill rest of the entries in table using recursive relation
    i: number of dice, j: sum */
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k < j && k <= m; k++)
                    table[i][j] += table[i - 1][j - k];
            }
        }

        //Uncomment these lines to see content of table
        //        for(int i = 0; i< n+1; i++){
        //            for(int j = 0; j< x+1; j++)
        //                System.out.print(table[i][j] + " ");
        //            System.out.println();
        //        }

        return table[n][x];
    }

    /**
     * Approach 2
     */

    public static int findWays2 (int d, int f, int target)
    {
        int[] ways = new int[target + 1];

        ways[0] = 1;

        for (int rep = 1; rep <= d; rep++) {

            int newWays[] = new int[target + 1];

            for (int already = 0; already <= target; ++already) {
                for (int pipe = 1; pipe <= f; ++pipe) {
                    if (already - pipe >= 0) {
                        newWays[already] += ways[already - pipe];
                        newWays[already] %= mod;
                    }
                }
            }
            ways = newWays;
        }
        return ways[target];
    }

    /**
     * Recursive way with memoize
     */
    static int[][] dp;

    public static int findWays3 (int d, int f, int target)
    {
        dp = new int[d + 1][Math.max(target, f) + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int x = helper(d, f, target);
        return x;

    }

    public static int helper (int d, int f, int target)
    {
        if (dp[d][target] != -1)
            return dp[d][target];

        //Base case
        if (d == 1) {
            if (target == 0) {
                return 0;
            }

            if (target <= f) {
                return 1;
            }
            return 0;
        }
        int ways = 0;
        for (int i = 1; i <= f; i++) {
            int l = helper(1, f, i);
            int r = target - i > 0 ? helper(d - 1, f, target - i) : 0;
            ways += (l * r) % mod;
            ways %= mod;
        }

        dp[d][target] = ways;
        return ways;

    }

    public static void main (String arg[])
    {
        // 1+6, 2+5, 3+4, 4+3, 5+2, 6+1, 6, 2, 7
        // 1+1+4, 1+2+3, 1+3+2, 1+4+1, 2+1+3, 2+2+2
        // 2+3+1, 3+1+2, 3+2+1, 4+1+1

        /**
         * 0 0 0 0 0 0 0
         * 0 1 1 1 1 1 1
         * 0 0 1 2 3 4 5
         * 0 0 0 1 3 6 10
         *
         * columns denotes the number we are searching
         * rows denotes number of dices
         * 10 = 4+3+2+1 from above row.
         */
        //System.out.println(findWays(6, 3, 6));
        //System.out.println(findWays2(6, 3, 6));
        System.out.println(findWays3(6, 3, 6));
        System.out.println(findWays3(3, 4, 6));
    }
}
