package dp;

/**
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 */
public class MinimumFallingPath {
    public static int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int min = Integer.MAX_VALUE;

        int [][] dp = new int[rows][cols];

        for(int i=0; i<cols; i++){
            dp[0][i] = A[0][i];
            min = Math.min(min, dp[0][i]);
        }

        for(int i =1; i<rows; i++){
            min = Integer.MAX_VALUE;
            for(int j = 0; j<cols; j++){
                int num = dp[i-1][j];
                if(j>0){
                    num = Math.min(num, dp[i-1][j-1]);
                }
                if(j<cols-1){
                    num = Math.min(num, dp[i-1][j+1]);
                }

                dp[i][j] = num + A[i][j];
                min = Math.min(min, dp[i][j]);
            }
        }

        return min;
    }
    public static void main(String arg[]){
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(mat));

    }
}
