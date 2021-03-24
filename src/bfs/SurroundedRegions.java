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
    public void surroundedRegions(char[][] board){
        if(board == null || board.length ==0 || board[0].length ==0)
            return;

        Queue<Integer> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        for(int i =0; i<m; i++){
            for(int j =0; j< n; j++){
                if(board[i][j]=='0' && !visited[i][j]){
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

                        }

                    }
                }
            }
        }
    }
}
