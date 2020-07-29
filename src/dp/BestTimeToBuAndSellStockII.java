package dp;

public class BestTimeToBuAndSellStockII
{
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int n = prices.length;

        int i=0;

        while(i<n-1) {
            //Find local min
            // Next i  should  be less  than current  i
            while(i<n-1 && prices[i+1]<= prices[i]) i++;

            if(i==n-1)
                break;

            int buyIndex = i;
            i++;


            //current i should be > previous i
            while(i<n && prices[i]>=prices[i-1]) i++;

            int selIndex= i-1;
            maxProfit +=prices[selIndex]-prices[buyIndex];
        }
        return maxProfit;

    }

    /**
     * Optimized one
     *
     * https://medium.com/algorithms-and-leetcode/best-time-to-buy-sell-stocks-on-leetcode-the-ultimate-guide-ce420259b323
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit =0;
        int n = prices.length;

        int i=1;

        while(i<n) {
            maxProfit += Math.max(prices[i]-prices[i-1], 0);
        }
        return maxProfit;

    }
}
