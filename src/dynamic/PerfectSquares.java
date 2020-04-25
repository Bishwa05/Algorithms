package dynamic;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class PerfectSquares {

    public static int numSquare(int n){
        int []dp = new int[n+1];

        for(int i =1; i<=n; i++){
            dp[i]= Integer.MAX_VALUE;
        }

        for(int i=1; i<=n; i++){
            for(int j =1; j*j<=n; j++){
                int x = j*j;
                if(x<=i){
                    dp[i] = Math.min(dp[i-x]+1, dp[i]);
                }
            }

        }
        return dp[n];
    }
    public static void main(String arg[]) {
        int n = 21;
        System.out.println(numSquare(n));

    }
}
