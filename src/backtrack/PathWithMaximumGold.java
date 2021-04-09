package backtrack;

public class PathWithMaximumGold
{

    int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int max = Integer.MIN_VALUE;
    public int getMaximumGold(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m ; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] != 0)
                    dfs(grid, i, j, 0);
        return max;
    }

    private void dfs(int[][] grid, int x, int y, int val){
        max = Math.max(val + grid[x][y], max);
        int origin = grid[x][y];
        grid[x][y] = 0; // Mark as visited
        for(int dir[] : dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length
                || grid[nx][ny] == 0
            )
                continue;
            dfs(grid, nx, ny, val + origin);
        }

        grid[x][y] = origin; // Backtrack
    }



    public static void main(String arg[]){

        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        PathWithMaximumGold g = new PathWithMaximumGold();
        System.out.println(g.getMaximumGold(grid));

    }


}
