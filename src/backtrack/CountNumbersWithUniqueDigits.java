package backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description
 *
 * Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
 *
 */
public class CountNumbersWithUniqueDigits
{
    int count =0;

    //DP
    public int countNumbersWithUniqueDigits(int n) {
        int dp[] = new int[n+1];
        if(n==0)
            return 1;
        dp[1]=10;
        int multiplier = 9;

        for(int i=2;i<=n;i++) {
            multiplier *= (10-i+1);
            dp[i] += multiplier+dp[i-1];
        }

        return dp[n];

    }

    public int countNumbersWithUniqueDigitsDFS(int n) {
        if(n == 0) return 1;
        else if(n == 1) return 10;
        else return 10 + 9*count(Math.min(n-1, 9), 9);
    }

    private int count(final int depth, final int usable) {
        if(depth == 0 || usable == 0) return 0;

        //x, usable 3
        //x1, x2, x3
        //x1 * (2,3)
        //x2 * (1,3)
        //x3 * (1,2)
        int ans = usable + usable * count(depth-1, usable - 1);

        return ans;
    }

    public static void main(String arg[]){
        CountNumbersWithUniqueDigits c = new CountNumbersWithUniqueDigits();
        System.out.println(c.countNumbersWithUniqueDigits(2));
    }
}
