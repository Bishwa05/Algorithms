package dynamic;

/**
 * vector<int> data(n+1, INT_MAX);
 *         data[0] = 0, data[1] = 0;
 *         for (int i = 1; i <= n; ++i) {
 *             for (int j = 2; i * j <= n; ++j) {
 *                 int k = i * j;
 *                 data[k] = min(data[k], data[i] + j);
 *             }
 *         }
 */
public class TwoKeysKeyboard {
    public static int minSteps(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i]= Integer.MAX_VALUE;
        }

        for(int i=1; i<=n; i++){
            for(int j =2; j*i <=n; j++){
                int k = j*i;
                dp[k]= Math.min(dp[k], dp[i]+j);
            }
        }
    return dp[n];
    }

    //prime factorization
    public int minSteps_primeFactorization(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }

    public static void main(String arg[]){
        int n =8;
        System.out.println(minSteps(n));
    }
}
