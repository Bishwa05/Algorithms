package dp;

/**
 * Leetcode 361
 * https://leetcode.com/problems/bomb-enemy/
 *
 *
 *
 *  0, E, 0, 0
 *  E, 0, W, E
 *  0, E, 0, 0
 *
 *  E -> Enemy
 *  0 -> empty cell, bomb can be placed
 *  W -> wall, bomb ca not pass through wall.
 *
 */
public class BombEnemy
{
    private static final char WALL='W';
    private static final char ENEMY='E';
    private static final char EMPTY='0';

    public int maxKilledEnemies(char[][] grid){
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        int n = m==0?0: grid[0].length;
        int maxEnemies =0;
        int rowHits = 0;
        int[] colHits = new int[n];

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == WALL){
                    continue;
                }
                if(j == 0 || grid[i][j-1]==WALL){
                    rowHits = 0;
                    for(int k =j; k<n && grid[i][k] != WALL; k++){
                        if(grid[i][k] == ENEMY){
                            rowHits++;
                        }
                    }
                }

                if(i==0 || grid[i-1][j]== WALL){
                    colHits[j] =0;
                    for(int k =i; k<m && grid[k][j]!= WALL; k++){
                        if(grid[k][j]==ENEMY){
                            colHits[j]++;
                        }
                    }
                }

                if(grid[i][j]== EMPTY){
                    maxEnemies = Integer.max(rowHits+ colHits[j], maxEnemies);
                }

            }
        }
        return maxEnemies;
    }

    public static void main(String arg[]){
        BombEnemy b = new BombEnemy();
        char[][] c= {{'0','E','0', '0'},
                    {'E','0','W','E'},
                    {'0', 'E', '0', '0'}};
        System.out.println(b.maxKilledEnemies(c));
    }
}
