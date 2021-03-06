package dp;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
 */
public class CuttingRod
{
    public static  int dfs(int price[], int n) {

        if(n ==0) return 0;
        int max =0;
        for(int i=1; i<= n; i++){
            max = Math.max(max, dfs(price, n-i) +price[i-1]);

        }
        return max;
    }

    // Memo populate cache in util method with size+1
    static int cache[] = new int[9];
    public static int dfsMemo(int []price, int n){

        if(n ==0) return 0;
        if(cache[n] >0) return cache[n];


        int max = 0;
        for(int i =1; i<=n; i++){
            max = Math.max(max, dfsMemo(price,n-i) + price[i-1]);
        }
        cache[n] = max;
        return max;

    }

    static int cutRod (int price[], int n)
    {
        int val[] = new int[n + 1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, price[j] + val[i - j - 1]);
            val[i] = max_val;
        }

        return val[n];
    }

    public static void main (String args[])
    {
        int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + dfsMemo(arr, size));
    }
}
