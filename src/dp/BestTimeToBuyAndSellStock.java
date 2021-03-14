package dp;

/**
 * 121. Best Time to Buy and Sell Stock
 * Leetcode
 */
public class BestTimeToBuyAndSellStock
{

    public int maxProfit (int[] prices)
    {
        //         int maxProfit =0;
        //         for(int i = prices.length-1; i>0;  i--){
        //             int profit = 0;
        //             for(int j= i-1; j>=0; j--){
        //                 if(prices[i]<prices[j]){
        //                     continue;
        //                 }
        //                 profit = Math.max(profit,prices[i]-prices[j]);

        //             }
        //             if(profit>maxProfit){
        //                 maxProfit = profit;
        //             }
        //             profit =0;
        //         }
        //     return maxProfit;

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfitDP (int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) //n=(int)prices.size();
        {
            dp[i][1] = Math.max(dp[i - 1][1], prices[i - 1] - dp[i - 1][0]);
            dp[i][0] = Math.min(prices[i - 1], dp[i - 1][0]);
        }
        return dp[n][1];
    }

}
