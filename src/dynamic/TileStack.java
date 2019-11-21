package dynamic;

public class TileStack {
    static int N = 100;

    static int possibleWays(int n, int m, int k)
    {
        int[][] dp = new int[N][N];
        int[][] presum = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                dp[i][j] = 0;
                presum[i][j] = 0;
            }
        }

        // Initialing 0th row to 0.
        for (int i = 1; i < n + 1; i++)
        {
            dp[0][i] = 0;
            presum[0][i] = 1;
        }

        // Initialing 0th column to 0.
        for (int i = 0; i < m + 1; i++)
        {
            presum[i][0] = dp[i][0] = 1;
        }

        // For each row from 1 to m
        for (int i = 1; i < m + 1; i++)
        {

            // For each column from 1 to n.
            for (int j = 1; j < n + 1; j++)
            {

                // Initialing dp[i][j] to presum of (i - 1, j).
                dp[i][j] = presum[i - 1][j];
                if (j > k)
                {
                    dp[i][j] -= presum[i - 1][j - k - 1];
                }
            }

            // Calculating presum for each i, 1 <= i <= n.
            for (int j = 1; j < n + 1; j++) {
                presum[i][j] = dp[i][j] + presum[i][j - 1];
            }
        }

        return dp[m][n];
    }

    // Driver Program
    public static void main(String[] args) {
        int n = 3, m = 3, k = 2;
        System.out.println(possibleWays(n, m, k));
    }

}
