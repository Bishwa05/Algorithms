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

    public int findLPSLengthMemo(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length()-1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;

        // every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex)
            return 1;

        if(dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if(st.charAt(startIndex) == st.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(dp, st, startIndex+1, endIndex-1);
            } else {
                // case 2: skip one element either from the beginning or the end
                int c1 =  findLPSLengthRecursive(dp, st, startIndex+1, endIndex);
                int c2 =  findLPSLengthRecursive(dp, st, startIndex, endIndex-1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }
        }

        return dp[startIndex][endIndex];
    }

    // Bottom - up
    public int findLPSLength(String st) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 1;

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }

    public static  void main(String arg[]) {
        String inp = "ABBACDEEDC";
        System.out.println(longestPallindromeSubsequence(inp, 0, inp.length()-1));
    }
}
