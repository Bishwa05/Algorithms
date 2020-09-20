package backtrack;

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

    public static void main(String arg[]){
        int[][] arr = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        UniquePathsIII u = new UniquePathsIII();
        System.out.println(u.uniquePathsIII(arr));
    }
}
