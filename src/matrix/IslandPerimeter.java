package matrix;

public class IslandPerimeter {
    int perimeter = 0;
    public int findIslandPerimeter(int[][] matrix) {
        // TODO: Write your code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    return findPerimeter(matrix, visited, i, j);
                }
            }
        }

        return 0;
    }

    private int findPerimeter(int[][] matrix, boolean[][] visited,  int i, int j) {
        if (i <0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 1;
        // returning 1, since this a boundary cell initiated this DFS call
        if (matrix[i][j] == 0) return 1; // returning 1, because of the shared side b/w a water and a land cell

        if (visited[i][j]) return 0;

        visited[i][j] = true;

        int edge = 0;
        edge += findPerimeter(matrix, visited, i+1, j);
        edge += findPerimeter(matrix, visited, i-1, j);
        edge += findPerimeter(matrix, visited, i, j+1);
        edge += findPerimeter(matrix, visited, i, j-1);
        return edge;
    }
}
