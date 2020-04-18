package dfs;

public class MaxAreaOfIsland {
    public static int dfsToAll(int[][] grid, int row, int col, int area) {
        if(grid[row][col]==0) return area;

        grid[row][col] =0;
        area = area+1;

        if(row+1<grid.length) area = dfsToAll(grid,row+1,col, area);
        if(row-1>=0) area = dfsToAll(grid,row-1,col, area);

        if(col+1<grid[0].length) area =  dfsToAll(grid,row,col+1, area);
        if(col-1>=0) area = dfsToAll(grid,row,col-1, area);

        return area;
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int maxArea =0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int area =0;
                    area = dfsToAll(grid, i, j, area);

                    if(area>maxArea) maxArea = area;
                }
            }
        }
        return maxArea;

    }

    public static void main(String arg[]){

//        char [][] grid = {{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0','0','0','0','0'}
//        };

        int [][] grid ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        //int [][] grid ={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));

    }
}
