package matrix;

/**
 * Any image can be represented by a 2D integer array (i.e., a matrix) where each cell
 * represents the pixel value of the image.
 *
 * Flood fill algorithm takes a starting cell (i.e., a pixel) and a color.
 * The given color is applied to all horizontally and vertically connected cells with
 * the same color as that of the starting cell. Recursively, the algorithm fills cells
 * with the new color until it encounters a cell with a different color than the starting cell.
 *
 * Given a matrix, a starting cell, and a color, flood fill the matrix.
 *
 */
public class FloodFill {
    public int[][] floodFill(int[][] matrix, int x, int y, int newColor) {
        // TODO: Write your code here

        fillDFS(matrix, x, y, matrix[x][y], newColor);
        return matrix;
    }

    private void fillDFS(int[][] matrix, int i, int j, int cellValue, int newColor) {

        if (i < 0 || i >= matrix.length || j < 0|| j >= matrix[0].length) return;

        if (matrix[i][j] == newColor) return;

        if (cellValue != matrix[i][j]) return;
        matrix[i][j] = newColor;

        fillDFS(matrix, i+1, j, cellValue, newColor);
        fillDFS(matrix, i-1, j, cellValue, newColor);
        fillDFS(matrix, i, j+1, cellValue, newColor);
        fillDFS(matrix, i, j-1, cellValue, newColor);
    }
}
