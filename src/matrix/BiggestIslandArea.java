package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BiggestIslandArea {

    public int maxAreaOfIsland(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int biggestIslandArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) { // only if the cell is a land
                    // we have found an island
                    biggestIslandArea = Math.max(biggestIslandArea, visitIslandDFS(matrix, i, j));
                }
            }
        }
        return biggestIslandArea;
    }

    private static int visitIslandDFS(int[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return 0; // return, if it is not a valid cell
        if (matrix[x][y] == 0)
            return 0; // return, if it is a water cell

        matrix[x][y] = 0; // mark the cell visited by making it a water cell

        int area = 1; // counting the current cell
        // recursively visit all neighboring cells (horizontally & vertically)
        area += visitIslandDFS(matrix, x + 1, y); // lower cell
        area += visitIslandDFS(matrix, x - 1, y); // upper cell
        area += visitIslandDFS(matrix, x, y + 1); // right cell
        area += visitIslandDFS(matrix, x, y - 1); // left cell

        return area;
    }


    public int maxAreaOfIslandBFS(int[][] grid) {
        // Check if the grid is null or empty
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions array to traverse right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start a BFS if the cell contains land (1)
                if (grid[i][j] == 1) {
                    // Update maxArea with the larger area found
                    maxArea = Math.max(maxArea, bfs(grid, i, j, directions));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0; // Mark the cell as visited
        int area = 0;

        // Process each cell in the queue
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            area++; // Increment the area for the current island

            // Check all four possible directions
            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                // Check if the new position is within bounds and is land
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0; // Mark the cell as visited
                }
            }
        }

        return area;
    }



    public static void main(String[] args) {
        BiggestIslandArea sol = new BiggestIslandArea();
        System.out.println(sol.maxAreaOfIsland(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));
    }
}


