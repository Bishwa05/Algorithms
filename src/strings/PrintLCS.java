package strings;

import java.util.*;

public class PrintLCS {

    // Function to fill lookup table by finding the length of LCS
    // of substring X and Y
    public static void LCSLength(String X, String Y, int[][] T)
    {
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= X.length(); i++)
        {
            for (int j = 1; j <= Y.length(); j++)
            {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    T[i][j] = T[i - 1][j - 1] + 1;

                    // else if current character of X and Y don't match
                else
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
            }
        }
    }


    public static List<String> LCS(String X, String Y, int m, int n, int [][]T) {
        if(m ==0 || n ==0) {
            // create a List with 1 empty string and return
            return new ArrayList(Collections.nCopies(1, ""));
        }

        if(X.charAt(m-1)== Y.charAt(n-1)){
            // ignore last characters of X and Y and find all LCS of
            // substring X[0..m-2], Y[0..n-2] and store it in a List
            List<String> lcs = LCS(X,Y,m-1,n-1,T);

            // append current character X[m - 1] or Y[n - 1]
            // to all LCS of substring X[0..m-2] and Y[0..n-2]
            for (int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + (X.charAt(m - 1)));
            }

            return lcs;
        }

        //Here last char of X and Y does not match

        //if the top cell of current cell has more value than the left cell,
        //then ignore current character of String X and find all LCS of
        //substring X[0..m-2], Y[0..n-1]
        if (T[m - 1][n] > T[m][n - 1])
            return LCS(X, Y, m - 1, n, T);


        // if left cell of current cell has more value than the top cell,
        // then ignore current character of String Y and find all LCS of
        // substring X[0..m-1], Y[0..n-2]
        if (T[m][n - 1] > T[m - 1][n])
            return LCS(X, Y, m, n - 1, T);

        // if top cell has equal value to the left cell,
        // then consider both character

        List<String> top = LCS(X, Y, m - 1, n, T);
        List<String> left = LCS(X, Y, m, n - 1, T);

        // merge two Lists and return
        top.addAll(left);

        return top;

    }

    // Function to find all LCS of String X[0..m-1] and Y[0..n-1]
    public static Set<String> LCS(String X, String Y, int[][] T)
    {
        // fill lookup table
        LCSLength(X, Y, T);

        // find all longest common sequences
        List<String> lcs = LCS(X, Y, X.length(), Y.length(), T);

        // since List can contain duplicates, "convert" the list
        // to Set and return
        return new HashSet<>(lcs);
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        // T[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]
        int[][] T = new int[X.length() + 1][Y.length() + 1];

        Set<String> lcs = LCS(X, Y, T);

        // print set elements
        System.out.print(lcs);
    }
}
