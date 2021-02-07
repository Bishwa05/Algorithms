package dp;

/**
 * Leetcode 343. Integer Break
 */
public class IntegerBreak
{
    public int integerBreak(int n){
        int[] dp = new int[n+1];

        for(int i=1; i<n; i++){
            for(int j =1; j<i+1; j++){
                if(i+j<=n){
                    dp[i+j] = Math.max(Math.max(dp[i], i)*
                        Math.max(dp[j], j), dp[i+j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String arg[]){
        IntegerBreak i = new IntegerBreak();
        System.out.println(i.integerBreak(10));
    }
}
