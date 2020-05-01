package dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
                     K(3, 2)         ---------> K(n, W)
                /               \
                /               \
            K(2,2)                   K(2,1)
        /       \                  /        \
        /           \              /        \
    K(1,2)      K(1,1)        K(1,1)     K(1,0)
    /  \         /   \          /           \
    /      \     /       \      /           \
 K(0,2)  K(0,1)  K(0,1)  K(0,0)  K(0,1)   K(0,0)

 */
public class Knapsack01 {

    /**
     * Base case if capacity is 0 then dont add to Bag.
     *
     * Either we add to bag or not at every step based on max value
     * Time complexity : O(2^n)
     */
    public int findMaxValue(int itemIndex, int capacity, int[] weights, int[] values) {

        if(capacity <0){
            return Integer.MIN_VALUE;
        }

        if(itemIndex<0 || capacity == 0){
            return 0;
        }

        int weight = weights[itemIndex];
        int value = values[itemIndex];

        int include = value + findMaxValue(itemIndex - 1, capacity - weight, weights, values);
        int notInclude = findMaxValue(itemIndex - 1, capacity,  weights, values);
        return Math.max(include, notInclude);
    }


    /**
     * Time complexity O(w*v)
     */


    public int knapsackMemoize(int n, int W, int wt[], int val[],  Map<String, Integer> map) {
        if(n <0){
            return Integer.MIN_VALUE;
        }

        if(n<0 || W == 0){
            return 0;
        }

        String key = n+"|"+W;

        if(!map.containsKey(key)) {
            int weight = wt[n];
            int value = val[n];

            int include = value + knapsackMemoize(n - 1, W - weight, wt, val,map);
            int notInclude = knapsackMemoize(n - 1, W,  wt, val, map);
            map.put(key,Math.max(include, notInclude));
        }
        return map.get(key);
    }


    public int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0) {
                    K[i][w] = 0;

                } else if (wt[i-1] <= w) {
                    // the maximum of two cases:
                    // (1) nth item included
                    // (2) not included
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                } else {
                    // If weight of the nth item is more
                    // than Knapsack capacity W, then
                    // this item cannot be included
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        return K[n][W];
    }


    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        Knapsack01 k = new Knapsack01();
       System.out.println(k.knapSack(W, wt, val, n));
       Map<String, Integer> map = new HashMap<>();
        System.out.println(k.knapsackMemoize(n-1,W, wt, val, map));

    }
}
