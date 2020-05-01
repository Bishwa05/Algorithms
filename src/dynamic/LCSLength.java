package dynamic;

import java.util.HashMap;
import java.util.Map;

public class LCSLength {
    /**
     * Time complexity of this approach is O(2^(m+n))
     */
    public int lcsLengthRec(String X, String Y, int m, int n){
        if(m ==0 || n==0){
            return 0;
        }

        if(X.charAt(m-1) == Y.charAt(n-1)){
            return 1+ lcsLengthRec(X, Y, m-1, n-1);
        }
        return Integer.max(lcsLengthRec(X, Y, m, n-1),
                lcsLengthRec(X, Y, m-1, n));
    }

    public int lcsLengthMemoize(String X, String Y, int m, int n, Map<String, Integer> map){
        if (m==0 || n==0){
            return 0;
        }

        String key = m+"|"+n;

        if(!map.containsKey(key)) {
            if(X.charAt(m-1) == Y.charAt(n-1)) {
                map.put(key, 1+ lcsLengthRec(X, Y, m-1, n-1));
            } else{
                map.put(key,Integer.max(lcsLengthRec(X, Y, m, n-1),
                        lcsLengthRec(X, Y, m-1, n)));
            }
        }
        return map.get(key);

    }


    /* Returns length of lcs for X[0..m-1], Y[0..n-1] */
    public int lcsLength( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

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
        LCSLength lcs = new LCSLength();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of lcs is" + " " +
                lcs.lcsLength( X, Y, m, n ) );

        Map<String, Integer> map = new HashMap<>();
        System.out.println("Length of lcs is" + " " +
                lcs.lcsLengthMemoize( s1, s2, m, n, map) );

        System.out.println("Length of lcs is" + " " +
                lcs.lcsLengthRec( s1, s2, m, n ) );
    }
}
