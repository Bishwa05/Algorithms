package dp;

/**
 * Leetcode 91.
 */
public class DecodingWays
{
    static int count =0;
    public void dfs(String s, int i){

        if (i >= s.length()) {
            count++;
            return;
        }
        if (s.charAt(i) == '0') return; // handle cases like 210 or 1010.
        dfs(s, i + 1);
        if (i + 1 < s.length()) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6') {
                dfs(s, i + 2);
            }
        }

    }

    public int numDecodings (String s)
    {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    // Another approach

    public int numDecodings2(String s) {
        if(s.charAt(0) == '0') return 0;

        int one = 1;
        int two = 1;
        for (int i = 0; i < s.length(); i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current = one;
            }
            int value = Integer.parseInt(s.substring(i-1, i+1));
            if (value >= 10 && value <=26) {
                current = current + two;
            }
            two = one;
            one = current;
        }
        return one;
    }

    public static void main (String arg[])
    {
        DecodingWays d = new DecodingWays();
        System.out.println(d.numDecodings("12615"));
        d.dfs("12615", 0);
        System.out.println(count);
    }

}
