package strings;

/**
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * Time complexity : O(n^2)
 */

public class LongestPalindromicSubString {

    public static String findMaxPalindrome(String str) {
        if (str == null || str.length() <1) return "";

        int start =0;
        int end =0;

        for(int i=0; i< str.length(); i++) {
            int len1 = expandFromMiddle(str, i, i);
            int len2 = expandFromMiddle(str, i, i+1);

            int len = Math.max(len1, len2);

            if(len > end -start) {
                start = i - ((len -1)/2);
                end = i + (len/2);
            }
        }

        return str.substring(start, end+1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if(s == null || left > right) return 0;

        while(left >= 0 && right <s.length()
        && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right -left -1;
    }


    /**
     * DP in action
     * Time O(3^n)
     *
     * The brute-force solution will be to try all the substrings of the given string. We can start processing from the beginning and the end of the string. So at any step, we will have two options:
     *
     * 1. If the element at the beginning and the end are the same, we make a recursive call to check if the remaining substring is also a palindrome. If so, the substring is a palindrome from beginning to end.
     * 2. We will skip either the element from the beginning or the end to make two recursive calls for the remaining substring. The length of LPS would be the maximum of these two recursive calls.
     *
     */

    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
            return 1;

        // case 1: elements at the beginning and the end are the same
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            int remainingLength = endIndex - startIndex - 1;
            // check if the remaining string is also a palindrome
            if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
                return remainingLength + 2;
        }

        // case 2: skip one character either from the beginning or the end
        int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }
//---------------------------------------------------------


    // Top -down DP

    public int findLPSLengthMemo(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
            return 1;

        if (dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                int remainingLength = endIndex - startIndex - 1;
                // check if the remaining string is also a palindrome
                if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
                    dp[startIndex][endIndex] = remainingLength + 2;
                    return dp[startIndex][endIndex];
                }
            }

            // case 2: skip one character either from the beginning or the end
            int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
            int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }

        return dp[startIndex][endIndex];
    }
    //------------------------------------------------------------------------------------------
    // Bottom -up DP

    public int findLPSLengthBottomUp(String st) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = true;

        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    }
                }
            }
        }

        return maxLength;
    }
    //------------------------------------------------------------------------------------
    public static void main(String arg[]) {
        String str = "babad";
        System.out.println(findMaxPalindrome(str));
    }
}
