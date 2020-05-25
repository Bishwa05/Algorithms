package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class Triangle {

    /**
     * In this recursive solution we are going through each path in the triangle from top to bottom
     * and calculating the cost.
     *
     * The base case is in last row the min path is the value itself.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return findMinPath(triangle, 0, 0).intValue();

    }

    public Integer findMinPath(List<List<Integer>> triangle, int rowNum, int index) {
        List<Integer> row = triangle.get(rowNum);

        // base case, we are at the last row
        if (rowNum == triangle.size() - 1) {
            return row.get(index);
        }

        int currValue = row.get(index);
        int maxSumLeft = findMinPath(triangle, rowNum+1, index);
        int maxSumRight = findMinPath(triangle, rowNum+1, index+1);

        return currValue + Math.min(maxSumLeft, maxSumRight);

    }

    //memoization
    /**
     * memoization (Top Down approach)
     * Time complexity reduced here to O(n).
     *
     * We are putting the value to cache for the node which is computed earlier.
     */
    int [][] memoTable = new int[4][4];
    public int minimumTotalMemoization(List<List<Integer>> triangle, int rowNum, int index) {
        List<Integer> row = triangle.get(rowNum);
        // base case, we are at the last row
        if (rowNum == triangle.size() - 1) {
            return row.get(index);
        }
        Integer cachedValue = memoTable[rowNum][index];
        if (cachedValue == null) {
            int currentValue = row.get(index);
            int maxSumLeft = findMinPath(triangle, rowNum + 1, index);
            int maxSumRight = findMinPath(triangle, rowNum + 1, index + 1);
            int sumPath = currentValue + Math.min(maxSumLeft, maxSumRight);
            memoTable[rowNum][index] = sumPath;
            return sumPath;
        }
        return cachedValue;
    }

    /**
     *
     * DP with Bottom up approach
     *
     * Here the DP table build upside down as the base case recides in the base of triangle and that forms
     * the last row of ths DP table. The answer is present in DP[0][0]
     *
     */
    public Integer findMinPath(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        // init the first row
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            dp[triangle.size() - 1][i] = lastRow.get(i);
        }
        for (int i = triangle.size() - 2; i >=0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int maxSumLeft = dp[i + 1][j];
                int maxSumRight = dp[i + 1][j + 1];
                int currentValue = row.get(j);
                int sumPath = currentValue + Math.min(maxSumLeft, maxSumRight);
                dp[i][j] = sumPath;
            }
        }
        return dp[0][0];
    }


    public static void main(String arg[]){
        List out = new ArrayList();

        List in1 = Arrays.asList(2);
        List in2 = Arrays.asList(3,4);
        List in3 = Arrays.asList(6,5,7);
        List in4 = Arrays.asList(4,1,8,3);

        out.add(in1); out.add(in2); out.add(in3); out.add(in4);
        Triangle t =  new Triangle();
        //System.out.println(t.minimumTotal(out));
        System.out.println(t.findMinPath(out));
    }
}
