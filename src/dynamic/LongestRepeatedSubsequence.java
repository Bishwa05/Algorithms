package dynamic;

public class LongestRepeatedSubsequence {

    /**
     * m = str.length();
     * n = str.length();
     */
    public static int longestRepeatedSubSeqLength(String str, int m, int n) {
        if(m ==0 || n ==0){
            return 0;
        }

        if(str.charAt(m)  == str.charAt(n) && m!=n){
            return longestRepeatedSubSeqLength(str, m-1, n-1);
        }
        return Math.max(longestRepeatedSubSeqLength(str, m-1, n),
                longestRepeatedSubSeqLength(str, m, n-1));
    }

    public static String longestRepeatedSubSeq(String str)
    {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 0;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }


        String res = "";

        // Traverse dp[][] from bottom right
        int i = n, j = n;
        while (i > 0 && j > 0)
        {
            // If this cell is same as diagonally
            // adjacent cell just above it, then
            // same characters are present at
            // str[i-1] and str[j-1]. Append any
            // of them to result.
            if (dp[i][j] == dp[i - 1][j - 1] + 1)
            {
                res = res + str.charAt(i - 1);
                i--;
                j--;
            }

            // Otherwise we move to the side
            // that that gave us maximum result
            else if (dp[i][j] == dp[i - 1][j])
                i--;
            else
                j--;
        }

        // Since we traverse dp[][] from bottom,
        // we get result in reverse order.
        String reverse = "";


        for(int k = res.length() - 1; k >= 0; k--)
        {
            reverse = reverse + res.charAt(k);
        }


        return reverse;

    }

    public static void main(String args[])
    {
        String str = "AABEBCDD";
        System.out.println(longestRepeatedSubSeq(str));
    }



}
