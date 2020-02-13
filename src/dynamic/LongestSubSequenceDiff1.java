package dynamic;

/**
 * Input :  arr[] = {10, 9, 4, 5, 4, 8, 6}
 * Output :  3
 * As longest subsequences with difference 1 are, "10, 9, 8",
 * "4, 5, 4" and "4, 5, 6"
 *
 * Input :  arr[] = {1, 2, 3, 2, 3, 7, 2, 1}
 * Output :  7
 * As longest consecutive sequence is "1, 2, 3, 2, 3, 2, 1"
 *
 * dp[i] can be recursively written as:
 * dp[i] = 1 + max(dp[j]) where 0 < j < i and
 *        [arr[j] = arr[i] -1  or arr[j] = arr[i] + 1]
 * dp[i] = 1, if no such j exists
 *
 */
public class LongestSubSequenceDiff1 {

    static int longestSubseqWithDiffOne(int arr[],
                                        int n)
    {
        int dp[] = new int[n];
        for (int i = 0; i< n; i++)
            dp[i] = 1;

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if ((arr[i] == arr[j] + 1) ||
                        (arr[i] == arr[j] - 1))

                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int result = 1;
        for (int i = 0 ; i < n ; i++)
            if (result < dp[i])
                result = dp[i];
        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 3, 2};
        int n = arr.length;
        System.out.println(longestSubseqWithDiffOne(
                arr, n));
    }
}
