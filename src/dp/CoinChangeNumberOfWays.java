package dp;

import java.util.Arrays;
import java.util.Map;

public class CoinChangeNumberOfWays {

    public int makeChangeRec(int[] coins, int coinLength, int total){

        if(total ==0){
            return 1;
        }

        if(total<0 || coinLength <0){
            return 0;
        }

        return makeChangeRec(coins,coinLength-1, total)+
                makeChangeRec(coins,coinLength, total-coins[coinLength]);
    }


    public static int count(int S[], int n, int N, Map<String, Integer> lookup)
    {
        if (N == 0) {
            return 1;
        }

        if (N < 0 || n < 0) {
            return 0;
        }

        String key = n + "|" + N;

        if (!lookup.containsKey(key))
        {
            int include = count(S, n, N - S[n], lookup);
            int exclude = count(S, n - 1, N, lookup);

            lookup.put(key, include + exclude);
        }

        return lookup.get(key);
    }

    public int changeBottomUp(int amount, int[] coins) {

        int dp[] = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int coin:coins)
        {
            for(int j = coin; j<=amount; j++){
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args)
    {
        CoinChangeNumberOfWays c = new CoinChangeNumberOfWays();
        // n coins of given denominations
        int[] S = { 1, 2, 3 };

        // Total Change required
        int N = 4;

        System.out.println("Total number of ways to get desired change is "
                + c.makeChangeRec(S, S.length-1, N));
    }

}
