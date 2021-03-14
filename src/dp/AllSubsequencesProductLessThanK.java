package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Input : [1, 2, 3, 4]
 * k = 10
 * Output :11
 * The subsequences are {1}, {2}, {3}, {4},
 * {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4},
 * {1, 2, 3}, {1, 2, 4}
 * Input  : [4, 8, 7, 2]
 * k = 50
 * Output : 9
 */
public class AllSubsequencesProductLessThanK
{
    public static int computeProductDFS (int arr[], int k)
    {
        //int []a = new int[1];
        return dfs(arr, k, -1, 0);
    }

    public static int dfs (int[] arr, int k, int prod, int i)
    {
        if (i >= arr.length && 0 <= prod && prod < k) {
            return 1;
        }
        if (i >= arr.length || prod >= k) {
            return 0;
        }

        return dfs(arr, k, prod, i + 1) + dfs(
            arr,
            k,
            (prod < 0) ? arr[i] : prod * arr[i],
            i + 1);

    }

    /**
     * Memoized version.
     */
    public static int computeProductDFSMemo (int arr[], int k)
    {
        Map<String, Integer> map = new HashMap<>();
        return helper(arr, k, -1, 0, map);
    }

    public static int helper (int[] arr, int k, int prod, int i, Map<String, Integer> map)
    {
        String keys = prod + " " + i;
        if (i >= arr.length && 0 <= prod && prod < k) {
            return 1;
        }
        if (i >= arr.length || prod >= k) {
            return 0;
        }

        if (map.containsKey(keys)) {
            return map.get(keys);
        }

        int res;

        res = helper(arr, k, prod, i + 1, map) + helper(arr,
            k,
            (prod < 0) ? arr[i] : prod * arr[i],
            i + 1,
            map);
        map.put(keys, res);
        return res;

    }

    /**
     * Bottom up approach.
     */
    static int computeProduct (int arr[], int k)
    {

        int n = arr.length;

        int dp[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {

                // number of subsequence using j-1 terms
                dp[i][j] = dp[i][j - 1];

                // if arr[j-1] > i it will surely make
                // product greater thus it won't contribute
                // then
                if (arr[j - 1] <= i && arr[j - 1] > 0)

                    // number of subsequence using 1 to j-1
                    // terms and j-th term
                    dp[i][j] += dp[i / arr[j - 1]][j - 1] + 1;
            }
        }
        return dp[k][n];
    }

    public static void main (String arg[])
    {
        int arr1[] = { 1, 2, 3, 4 };
        int k = 10;
        System.out.println(computeProductDFS(arr1, k));

        //        int arr2[] ={4, 8, 7, 2};
        //        int k2 = 50;
        //        System.out.println(computeProduct(arr2, k2));
    }
}
