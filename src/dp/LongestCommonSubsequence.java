package dp;

public class LongestCommonSubsequence {

    // Traverse from bottom right to top left
    public static String lcs(String X, String Y, int m, int n, int[][] T)
    {
        if (m == 0 || n == 0) {
            return new String();
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return lcs(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }

        if (T[m - 1][n] > T[m][n - 1]) {
            return lcs(X, Y, m - 1, n, T);
        }
        else {
            return lcs(X, Y, m, n - 1, T);
        }
    }

    /* Returns length of lcs for X[0..m-1], Y[0..n-1] */
    public int lcsLength( char[] X, char[] Y, int m, int n , int[][] L)
    {

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of lcs of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }


    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int[][] T = new int[m + 1][n + 1];

        lcs.lcsLength( X, Y, m, n , T);

        System.out.print(lcs.lcs(s1, s2, m, n, T));

    }
}
