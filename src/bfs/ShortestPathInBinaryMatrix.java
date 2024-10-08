package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode : 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] != 0) {
            return -1;
        }

        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1},{1,-1}, {-1,-1}, {-1,1}};
        int level = 1;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int[] positions = queue.remove();
                int x = positions[0];
                int y = positions[1];

                if(x == rows-1 && y == cols-1){
                    return level;
                }

                for(int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >=0 && newX < rows && newY>=0 && newY < cols && grid[newX][newY] ==0) {
                        queue.add(new int[] {newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
