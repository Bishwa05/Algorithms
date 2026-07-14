package matrix;

/**
 *
 * Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
 * Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 *
 * Example 1:
 * Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * Output: true
 *
 */
public class CycleInMatrix {
    public boolean hasCycle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean [][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {// only if the cell is not visited
                    if (containsCycleDFS(matrix, visited, matrix[i][j], i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }

//    private boolean containsCycleDFS(char[][] matrix, boolean[][] visited, char startChar, int x, int y, int prevX, int prevY) {
//        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return false;
//
//        if (matrix[x][y] != startChar) return false; // different character which means a different island
//
//        if (visited[x][y]) return true; // found a cycle, as we are visiting an already visited valid cell
//
//        visited[x][y] = true; // mark the cell visited
//
//        // recursively visit all neighboring cells (horizontally & vertically)
//        if (x +1 != prevX && containsCycleDFS(matrix, visited, startChar, x+1, y, x, y)) return true; // down
//        if (x - 1 != prevX && containsCycleDFS(matrix, visited, startChar, x-1, y, x, y)) return true; // up
//        if (y +1 != prevY && containsCycleDFS(matrix, visited, startChar, x, y+1, x, y)) return true; // right
//        if (y -1 != prevY && containsCycleDFS(matrix, visited, startChar, x, y-1, x, y)) return true; // left
//
//        return false;
//    }

    // Define the directions: Down, Right, Up, Left
    int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean containsCycleDFS(char[][] matrix, boolean[][] visited, char startChar, int x, int y, int prevX, int prevY) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return false;
        if (matrix[x][y] != startChar) return false;
        if (visited[x][y]) return true;

        visited[x][y] = true;

        for (int[] dir : DIRS) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            // Skip the cell we just came from to prevent immediate backtracking
            if (nextX == prevX && nextY == prevY) {
                continue;
            }

            // Recursively visit the neighbor
            if (containsCycleDFS(matrix, visited, startChar, nextX, nextY, x, y)) {
                return true;
            }
        }

        return false;
    }
}
