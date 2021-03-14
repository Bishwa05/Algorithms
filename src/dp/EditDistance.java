package dp;

/**
 * Minimum edits required to make 2 strings equivalent.
 * "sunday"
 * "saturday"
 * This is also called Levenshtein distance.
 * dp[i][j] = 1 + min(dp[i][j - 1], // Insert
 * dp[i - 1][j], // Remove
 * dp[i - 1][j - 1]); // Replace
 */

public class EditDistance
{

    static int editDistDP (String str1, String str2, int m, int n)
    {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different, consider all
                    // possibilities and find the minimum
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],
                        Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        return dp[m][n];
    }

    public static void main (String args[])
    {
        //        String str1 = "sunday";
        //        String str2 = "saturday";
        String str1 = "a";
        String str2 = "ab";
        System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
    }
}
