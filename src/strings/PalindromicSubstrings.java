package strings;

public class PalindromicSubstrings {
    // Another approach
    public static int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += checkPalindrome(s, i, i);
            ans += checkPalindrome(s, i, i+1);
        }
        return ans;
    }

    public static int checkPalindrome(String str, int low, int high)
    {
        int len = str.length();
        int count = 0;

        // expand in both directions
        while (low >= 0 && high < len &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
            count++;
        }
        return count;
    }

    public static void main(String arg[]){
        String X = "abc";
        //System.out.println(findLongestPalindrome(X));
        System.out.println(countSubstrings(X));
    }
}
