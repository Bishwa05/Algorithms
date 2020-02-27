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

    public static void main(String arg[]) {
        String str = "babad";
        System.out.println(findMaxPalindrome(str));
    }
}
