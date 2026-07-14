package matrix;

/**
 * You are given a 2D matrix containing only 1s (land) and 0s (water).
 *
 * An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).
 *
 * A closed island is an island that is totally surrounded by 0s (i.e., water). This means all horizontally and vertically connected cells of a closed island are water. This also means that, by definition, a closed island can't touch an edge (as then the edge cells are not connected to any water cell).
 *
 * Write a function to find the number of closed islands in the given matrix.
 *
 */
public class NumberOfClosedIslands {
    public int countClosedIslands(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int countClosedIslands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    if (isClosedIslandDFS(matrix, visited, i, j)) {
                        countClosedIslands++;
                    }
                }
            }
        }
        return countClosedIslands;
    }

    private boolean isClosedIslandDFS(int[][] matrix, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= matrix.length || j <0 || j>= matrix[0].length) return false;

        if (matrix[i][j] == 0 || visited[i][j]) return true;

        visited[i][j] = true;
        // recursively visit all neighboring cells (horizontally & vertically)
        boolean isClosed = true;
        isClosed &= isClosedIslandDFS(matrix, visited, i+1, j);
        isClosed &= isClosedIslandDFS(matrix, visited, i-1, j);
        isClosed &= isClosedIslandDFS(matrix, visited, i, j+1);
        isClosed &= isClosedIslandDFS(matrix, visited, i, j-1);
        return isClosed;
    }
    public static void main(String[] args) {
        NumberOfClosedIslands sol = new NumberOfClosedIslands();
        System.out.println(sol.countClosedIslands(
                new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(sol.countClosedIslands(
                new int[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 }
                }));
    }
}
