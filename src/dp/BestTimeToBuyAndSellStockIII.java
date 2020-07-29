package dp;

/**
 *
 * 123. Best Time to Buy and Sell Stock III
 * Leetcode.
 * TODO: Whiteboard.
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;
        //only one trans
        int max=maxProfitOneTrans(prices,0,n-1);

        // two trans
        for(int i=1;i<n-1;i++){
            int sum= maxProfitOneTrans(prices,0,i)
                    +maxProfitOneTrans(prices,i+1,n-1);

            max=Math.max(sum,max);
        }

        return max;

    }

    public int maxProfitOneTrans(int[] prices, int buy, int sell){
        int [] dp = new int[sell-buy+1];
        int max=0;
        dp[0]=0;//buy->dp[0]
        for(int i=1;i<dp.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+prices[i+buy]-prices[i+buy-1];
            } else{
                dp[i] = prices[i+buy]-prices[i+buy-1];
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String arg[]) {
        int arr[] = {3,3,5,0,0,3,1,4};
        BestTimeToBuyAndSellStockIII  b = new  BestTimeToBuyAndSellStockIII();
        System.out.println(b.maxProfit(arr));
    }

    /**
     *
     * @param prices
     * @return
     *
     * Final Profit = (Initial Profit — Buying Price) + Selling Price
     */
    public int maxProfitSimple(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell= 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell =0;

        for(int price : prices){
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy+price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy+ price);

        }
        return secondSell;

    }
}
