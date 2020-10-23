package dp;

public class BestTimeToBuyAndSellStockIV
{
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if(n<2 || k<1 ) {
            return 0;
        }

        if(k>n/2){
            int profit =0;
            for(int i=1; i<n; i++){
                profit += Math.max(0, prices[i] -prices[i-1]);
            }

            return profit;
        }

        int [] buy = new int[k];
        int [] sell = new int[k];

        for(int i =0; i< buy.length; i++){
            buy[i] = Integer.MIN_VALUE;
        }

        for(int i =0; i<n; i++){
            for(int j=0; j<k;j++){
                buy[j] = Math.max(buy[j], (j>0?sell[j-1]:0)-prices[i]);
                sell[j] = Math.max(sell[j], buy[j]+prices[i]);
            }
        }

        return sell[k-1];

    }

    public static void main(String arg[]){
        int[] nums = {3,2,6,5,0,3};
        BestTimeToBuyAndSellStockIV b = new BestTimeToBuyAndSellStockIV();
        System.out.println(b.maxProfit(2, nums));
    }
}
