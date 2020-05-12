package array;

/**
 * 121. Best Time to Buy and Sell Stock
 * Leetcode
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
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

}
