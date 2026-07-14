package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a 2D matrix containing only 1s (land) and 0s (water).
 * An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).
 *
 * Two islands are considered the same if and only if they can be translated (not rotated or reflected) to equal each other.
 *
 * Write a function to find the number of distinct islands in the given matrix.
 */
public class DistinctIsland {
    public int findDistinctIslandsDFS(int[][] matrix) {
     int rows = matrix.length;
     int cols = matrix[0].length;
     boolean [][] visited = new boolean[rows][cols];
    Set<String> islandSet = new HashSet<>();

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] == 1 && !visited[i][j]) {
                StringBuilder islandTraversal = new StringBuilder();
                traverseIslandDFS(matrix, visited, i, j, islandTraversal, "O");
                islandSet.add(islandTraversal.toString());
            }
        }
    }
    return islandSet.size();
    }

    private void traverseIslandDFS(int[][] matrix, boolean [][] visited, int i, int j, StringBuilder islandTraversal, String direction) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;

        if (matrix[i][j] == 0 || visited[i][j]) return;

        islandTraversal.append(direction);
        visited[i][j] = true;
        // recursively visit all neighboring cells (horizontally & vertically)
        traverseIslandDFS(matrix, visited, i+1, j, islandTraversal, "D");
        traverseIslandDFS(matrix, visited, i-1, j, islandTraversal, "U");
        traverseIslandDFS(matrix, visited, i, j+1, islandTraversal, "R");
        traverseIslandDFS(matrix, visited, i, j-1, islandTraversal, "L");

        islandTraversal.append("B"); // back
    }

    public static void main(String[] args) {
        DistinctIsland sol = new DistinctIsland();
        System.out.println(sol.findDistinctIslandsDFS(
                new int[][] {
                        { 1, 1, 0, 1, 1 },
                        { 1, 1, 0, 1, 1 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 0, 1 },
                        { 0, 1, 1, 0, 1 }
                }));

        System.out.println(sol.findDistinctIslandsDFS(
                new int[][] {
                        { 1, 1, 0, 1 },
                        { 0, 1, 1, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 1, 0, 0 },
                        { 0, 1, 1, 0 }
                }));
    }

}
