package dp;

/**
 * eg. (assuming American coins: 1, 5, 10, and 25 cents)
 *         makeChange(1) = 1 (1)
 *         makeChange(6) = 2 (5 + 1)
 *         makeChange(49) = 7 (25 + 10 + 10 + 1 + 1 + 1 + 1)
 *
 * Given an unlimited Supply of coins of given denominations
 * find the minimum  number of coins required to get a desired change
 */


public class CoinChange {
    private int[] coins = new int[]{1,2,3};

    public int makeChange(int c) {
        if (c == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
        // Try removing each coin from the total and
        // see how many more coins are required
        for (int coin : coins) {
            // Skip a coin if it’s value is greater
            // than the amount remaining
            if (c - coin >= 0) {
                int currMinCoins = makeChange(c - coin);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
        // Add back the coin removed recursively
        return minCoins + 1;
    }

    // Top down dp solution. Cache the values
// as we compute them
    public int makeChangeTopDown(int c) {
        // Initialize cache with values as -1
        int[] cache = new int[c + 1];
        for (int i = 1; i < c + 1; i++)
            cache[i] = -1;
        return makeChange(c, cache);
    }
    // Overloaded recursive function
    private int makeChange(int c, int[] cache) {
        // Return the value if it’s in the cache
        if (cache[c] >= 0) return cache[c];

        int minCoins = Integer.MAX_VALUE;

        // Find the best coin
        for (int coin : coins) {
            if (c - coin >= 0) {
                int currMinCoins =
                        makeChange(c - coin, cache);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }

        // Save the value into the cache
        cache[c] = minCoins + 1;
        return cache[c];
    }

    // Bottom up dp programming solution.
    // Iteratively compute number of coins for
    // larger and larger amounts of change
    //  Accepted in leetcode
    public int makeChangeBottomUp(int c) {
        int[] cache = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            int minCoins = 99999;

            // Try removing each coin from the total
            // and see which requires the fewest
            // extra coins
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minCoins = Math.min(cache[i-coin] + 1, minCoins);
                }
            }
            cache[i] = minCoins;
        }

        return cache[cache.length-1]==99999?-1:  cache[cache.length-1];
    }

    public static void main(String arg[]){
        CoinChange c = new CoinChange();
        System.out.println(c.makeChange(6));
//        System.out.println(c.makeChangeTopDown(6));
//        System.out.println(c.makeChangeBottomUp(6));
//        System.out.println(c.makeChangeBottomUp(1));
    }
}
