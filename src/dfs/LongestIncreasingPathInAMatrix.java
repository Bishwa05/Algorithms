package dfs;

/**
 *
 * Leetcode : 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;

        // Try starting the path from every cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // Return cached result if already computed
        if (memo[i][j] != 0) return memo[i][j];

        int max = 1;
        // Explore all 4 neighbors (Up, Down, Left, Right)
        for (int[] d : DIRS) {
            int x = i + d[0];
            int y = j + d[1];

            // Only move to the next cell if it is within bounds and strictly greater
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && matrix[x][y] > matrix[i][j]) {
                int path = 1 + dfs(matrix, x, y, memo);
                max = Math.max(max, path);
            }
        }

        // Cache and return the result for cell (i, j)
        memo[i][j] = max;
        return max;
    }


    private static int dfsWithoutMemo(int[][] mat, int i, int j) {
        int maxSubPath = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x< mat.length && y >= 0 && y < mat[0].length && mat[x][y] > mat[i][j]) {
                maxSubPath = Math.max(maxSubPath, dfsWithoutMemo(mat, x, y));
            }
        }
        return maxSubPath + 1;
    }
}
