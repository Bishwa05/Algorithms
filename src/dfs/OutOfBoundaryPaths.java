package dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode
 * 576. Out of Boundary Paths
 *
 *
 * There is an m by n grid with a ball.
 * Given the start coordinate (i,j) of the ball,
 * you can move the ball to adjacent cell or cross
 * the grid boundary in four directions (up, down, left, right).
 * However, you can at most move N times. Find out the number of paths
 * to move the ball out of grid boundary. The answer may be very large,
 * return it after mod 10^9 + 7.
 *
 */
public class OutOfBoundaryPaths {

    int M = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N + 1];
        for (int[][] l : memo)
            for (int[] sl : l)
                Arrays.fill(sl, -1);
        return findPaths(m, n, N, i, j, memo);
    }

    public int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
        if (i == m || j == n || i < 0 || j < 0)
            return 1;
        if (N == 0)
            return 0;
        if (memo[i][j][N] >= 0)
            return memo[i][j][N];
        memo[i][j][N] = ((findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M
                + (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M) % M;
        return memo[i][j][N];

    }


    public int findPaths2(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }

        return result;
    }


    Map<String, Integer> map = new HashMap<>();
    public int findPaths3(int m, int n, int N, int i, int j) {
        if(i<0 || j<0 || m == i || n == j) return 1;

        if(N == 0) return 0;

        String key = i + "_" + j + "_" + N;
        if(!map.containsKey(key)){
            map.put(key, (
                            (findPaths(m, n, N-1, i+1, j)
                                    + findPaths(m, n, N-1, i-1, j)) % 1000000007
                                    + (findPaths(m, n, N-1, i, j+1)
                                    + findPaths(m, n, N-1, i, j-1)) % 1000000007
                    ) % 1000000007
            );
        }
        return map.get(key);
    }


    public int findPathsBruteForce(int m, int n, int N, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        return findPaths(m, n, N - 1, i - 1, j)
                + findPaths(m, n, N - 1, i + 1, j)
                + findPaths(m, n, N - 1, i, j - 1)
                + findPaths(m, n, N - 1, i, j + 1);
    }

}
