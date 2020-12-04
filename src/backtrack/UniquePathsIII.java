package backtrack;


/**
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 *
 */
public class UniquePathsIII
{

    int rows = 0;
    int cols = 0;
    int count_zero = 0;
    public int uniquePathsIII(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[] result = new int[1];
        rows = grid.length;
        cols = grid[0].length;

        int start_i = 0, start_j = 0;
        for(int i=0; i < rows; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j] == 0) count_zero++;
                if(grid[i][j] == 1){
                    start_i = i;
                    start_j = j;
                }
            }
        }

        dfs(grid, start_i, start_j, 0, result);
        return result[0];
    }

    private void dfs(int[][] grid, int i, int j,
                     int curr, int[] result) {

        if(i < 0 || i >= rows
            || j < 0 || j >= cols
            || grid[i][j] < 0) return;

        if(grid[i][j] == 1 && curr > 0) return;

        if( grid[i][j] == 2 ){
            if(curr == count_zero)
                result[0]++;
            return;
        }
        if(grid[i][j] == 0){
            grid[i][j] = -2;
            curr++;
        }

        dfs(grid, i+1, j, curr, result );
        dfs(grid, i-1, j, curr, result  );
        dfs(grid, i, j+1, curr, result );
        dfs(grid, i, j-1, curr, result );
        if(grid[i][j] == -2){
            grid[i][j] = 0;
            curr--;
        }
        return;
    }


//
//    public void dfs(int[][] grid, int i, int j, int curr, int[] result){
//
//        if(i<0 || i>= rows || j<0|| j>= cols || grid[i][j]<0) return;
//
//        if(grid[i][j] == 1 && curr > 0) return;
//
//        if(grid[i][j] == 2) {
//            if(curr == countZero) {
//                result[0]++;
//                return;
//            }
//        }
//        if(grid[i][j] == 0) {
//            grid[i][j] = -2;
//            curr++;
//        }
//
//        dfs(grid, i+1, j, curr, result);
//        dfs(grid, i-1, j, curr, result);
//        dfs(grid, i, j+1, curr, result);
//        dfs(grid, i, j-1, curr, result);
//
//        if(grid[i][j] == -2) {
//            grid[i][j] = 0;
//            curr--;
//        }
//        return;
//    }


    public static void main(String arg[]){
        int[][] arr = {{0,1},{2,0}};
        UniquePathsIII u = new UniquePathsIII();
        System.out.println(u.uniquePathsIII(arr));
    }
}
