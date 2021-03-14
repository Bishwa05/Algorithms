package dp;

/**
 * 63 Leetcodee
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathII
{

    public int uniquePathsWithObstacles (int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1)
            return 0;
        //dp[0][0] = 2;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 0) {
                obstacleGrid[i][0] = 0;

            }
            else {
                obstacleGrid[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 0) {
                obstacleGrid[0][i] = 0;
            }
            else {
                obstacleGrid[0][i] = 1;
            }

        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 2;
            }
            else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 2;
            }
            else {
                dp[0][i] = 1;
            }

        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (dp[i][j - 1] == 1 && dp[i - 1][j] == 1) {
                    dp[i][j] = 1;
                }
                else if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - 1;
                }
                else {
                    dp[i][j] = 1;
                }
            }

        }
        return dp[m - 1][n - 1] - 1;
    }

    public static void main (String arg[])
    {
        int mat[][] = { { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        UniquePathII u2 = new UniquePathII();
        System.out.println(u2.uniquePathsWithObstacles(mat));
    }
}
