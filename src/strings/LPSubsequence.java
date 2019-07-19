package strings;

/**
 * Code to find the longest pallindromic subsequence
 *
 * ABBACDEEDC - 10
 */
public class LPSubsequence {

    /**
     * Solve by recurssion
     * Time complexity O(2^n)
     */
    public static int longestPallindromeSubsequence(String X, int i, int j){
        if (i>j)
            return 0;
        if( i==j)
            return 1;

        if(X.charAt(i) == X.charAt(j)){
            return longestPallindromeSubsequence(X, i+1,j-1)+2;
        }

        return Integer.max(longestPallindromeSubsequence(X,i,j-1),
                longestPallindromeSubsequence(X,i+1, j));

    }

    /**
     * To find the same in top down approach
     * @param
     */


    public static  void main(String arg[]) {
        String inp = "ABBACDEEDC";
        System.out.println(longestPallindromeSubsequence(inp, 0, inp.length()-1));
    }
}
