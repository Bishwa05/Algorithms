package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int countIslands(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalIsland = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    totalIsland++;
                    visitIslandDFS(matrix, i, j);
                    // visitIslandBFS(matrix, i, j);
                }
            }
        }
        return totalIsland;
    }

    private void visitIslandDFS(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;

        if (matrix[i][j] == 0) return;

        matrix[i][j] = 0;

        visitIslandDFS(matrix, i+1, j);
        visitIslandDFS(matrix, i-1, j);
        visitIslandDFS(matrix, i, j+1);
        visitIslandDFS(matrix, i, j-1);
    }


    public void visitIslandBFS(int[][]matrix, int i, int j) {
        Queue<int[]> neighbours = new LinkedList<>();
        neighbours.add(new int[] {i, j});

        while (!neighbours.isEmpty()) {
            int row = neighbours.peek()[0];
            int col = neighbours.peek()[1];
            neighbours.remove();

            if (row < 0 || row >= matrix.length || col <0 || col>= matrix[0].length) continue;

            if (matrix[row][col] == 0) continue;

            neighbours.add(new int[] {row +1, col});
            neighbours.add(new int[] {row - 1, col});
            neighbours.add(new int[] {row, col + 1});
            neighbours.add(new int[] {row, col - 1});

        }
    }


    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();
        System.out.println(sol.countIslands(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));

        System.out.println(sol.countIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));
    }
}
