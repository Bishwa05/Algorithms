package bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode : 1631. Path With Minimum Effort
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        if (n==1 && m ==1) return 0;

        // stores the minimum effort required to travel upto a given cell.
        int efforts[][] = new int[n][m];
        for (int row[]: efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((t1,t2) -> (t1[2]-t2[2]));
        pq.offer(new int[]{0,0,0});
        int dir[][] = {{0,1},{0,-1}, {1,0}, {-1,0}};

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int wt = curr[2];

            for (int x[] : dir) {
                int nextRow = row + x[0];
                int nextCol = col + x[1];
                if(nextRow<0 || nextRow>=n || nextCol<0 || nextCol>=m)
                    continue;
                int nextWt = Math.max(wt, Math.abs(heights[nextRow][nextCol] - heights[row][col]));
                // updating the minimum effort
                if (nextWt<efforts[nextRow][nextCol]) {
                    efforts[nextRow][nextCol] = nextWt;
                    pq.offer(new int[]{nextRow, nextCol, nextWt});
                }
            }
        }
        return efforts[n-1][m-1];
    }
}
