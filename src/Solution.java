import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Point {
        int x;
        int y;
        public Point(int i, int j) {
            x = i;
            y = j;
        }
    }

    int count = 0;
    int[][] DIRS = new int[][] {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Point(i, j));

                }
            }
        }

        q.offer(null);
        bfs(q, grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;

    }

    public void bfs(Queue<Point> q, int[][] grid) {
        while(!q.isEmpty()) {
            Point p = q.poll();
            if (p == null) {
                if (!q.isEmpty()) {
                    count++;
                    q.offer(null);
                }
            } else {

                grid[p.x][p.y] = 0;

                for(int[] dir : DIRS) {
                    int x = p.x + dir[0];
                    int y = p.y + dir[1];
                    if ( x < 0 || x >= grid.length || y <0 || y >= grid[0].length) continue;

                    if(grid[x][y] == 1) {
                        q.offer(new Point(x, y));
                        grid[x][y] = 0;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{2,2},{1,1},{0,0},{2,0}};
        System.out.println(s.orangesRotting(arr));
    }
}
