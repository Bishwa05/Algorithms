package matrix;

public class RotateClockWiseAndAnticlockWise {


    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int first = 0, last = rows -1; first < last; first++, last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i+1; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }


    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */

    public void antiRotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int first = 0, last = cols -1; first < last; first++, last--) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = tmp;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
