package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 */
public class UniquePath {
    /**
     *     Time complexity O(2^(m+n))
     */

    public int uniquePaths(int m, int n) {
        return uniquePathsRec(1,1,m,n, 0);

    }

    private int uniquePathsRec(int i, int j, int x, int y, int ways){
        if(i==x && j ==y){
            return ++ways;
        }
        if(i>x || j>y){
            return ways;
        }
        return uniquePathsRec(i+1,j,x, y, ways)  +
                uniquePathsRec(i,j+1,x, y, ways);
    }

    /**
     *
     * This memoization is not working properly needs to revisit.
     */

//    public int uniquePathsMemoize(int m, int n) {
//        Map<String,Integer> map = new HashMap<>();
//        return uniquePathsMemoHelper(1,1,m,n, 0, map);
//    }
//
//    public int uniquePathsMemoHelper(int i, int j, int x, int y, int ways, Map<String, Integer>map){
//        if(i==x && j ==y){
//            return ++ways;
//        }
//        if(i>x || j>y){
//            return ways;
//        }
//        String key1 = i+1+"|"+j;
//        String key2 = i+"|"+j+1;
//
//        if(!map.containsKey(key1)){
//            map.put(key1, uniquePathsMemoHelper(i+1,j,x, y, ways, map));
//        }
//        if(!map.containsKey(key2)){
//            map.put(key2, uniquePathsMemoHelper(i,j+1,x, y, ways, map));
//        }
//        return  map.get(key1) + map.get(key2);
//    }

    public int uniquePathsDP(int m, int n) {

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] =1;
        }

        for(int i=0; i<n; i++){
            dp[0][i] =1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }

        }
        return dp[m-1][n-1];
    }

    public static void main(String arg[]){
        int m =9;
        int n = 11;
        UniquePath u  = new UniquePath();
        System.out.println(u.uniquePaths(m,n));
        //System.out.println(u.uniquePathsMemoize(m,n));
        System.out.println(u.uniquePathsDP(m,n));

    }
}
