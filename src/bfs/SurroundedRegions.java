package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 130
 *
 *      X X X X
 *      X 0 0 X
 *      X X X X
 *      X 0 X X
 */
public class SurroundedRegions
{
    public void solve(char[][] board){
        if(board == null || board.length ==0 || board[0].length ==0)
            return;

        Queue<Integer> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        for(int i =0; i<m; i++){
            for(int j =0; j< n; j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    boolean surround = true;
                    List<Integer> pointsToChange = new ArrayList<>();
                    q.add(i*n + j);// add root
                    visited[i][j] = true;

                    while(q.size()>0){
                        int point = q.poll();
                        pointsToChange.add(point);

                        int x = point/n;
                        int y = point%n;

                        //try in all directions
                        for(int k = 0; k< dir.length; k++){
                            int nextX = x+dir[k][0];
                            int nextY = y +dir[k][1];

                            if(nextX >=0 && nextX <m && nextY >=0 && nextY<n){
                                if(board[nextX][nextY]=='O' && !visited[nextX][nextY]){
                                    q.add(nextX*n+nextY);
                                }
                                visited[nextX][nextY] = true;
                            } else{
                                surround = false;
                            }

                        }

                    }

                    if(surround){
                        for(int p : pointsToChange)
                            board[p/n][p%n] ='X';
                    }
                }
            }
        }
    }

    /**
     * Another approach, dfs
     */
    public void solveEfficientOne(char[][] board) {
        if(board == null || board.length==0)
            return;

        int m = board.length;
        int n = board[0].length;

        //merge O's on left & right boarder
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                merge(board, i, 0);
            }

            if(board[i][n-1] == 'O'){
                merge(board, i, n-1);
            }
        }

        //merge O's on top & bottom boarder
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O'){
                merge(board, 0, j);
            }

            if(board[m-1][j] == 'O'){
                merge(board, m-1, j);
            }
        }

        //process the board
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void merge(char[][] board, int i, int j){
        board[i][j] = '#';

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int k=0; k<4; k++){
            int x = i+dx[k];
            int y = j+dy[k];

            if(x>=0 && x<board.length
                && y>=0 && y<board[0].length
                && board[x][y]=='O'){
                merge(board, x, y);
            }
        }
    }
}
