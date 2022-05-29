package binarysearch;

import java.util.Arrays;

/**
 * Leetcode : 354. Russian Doll Envelopes
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0]== b[0]?b[1]-a[1]: a[0]-b[0]);
        int[] LIS = new int[envelopes.length +1];
        Arrays.fill(LIS, Integer.MAX_VALUE);
        LIS[0] = Integer.MIN_VALUE;
        int ans = 0;

        for(int i =0; i<envelopes.length; i++) {
            int val = envelopes[i][1];
            int insertIndex = binarySearch(LIS, val);
            ans = Math.max(ans, insertIndex);
            if(LIS[insertIndex]>=val) {
                LIS[insertIndex] = val;
            }
        }
        return ans;

    }

    private int binarySearch(int[] dp, int val) {
        int lo = 0, hi = dp.length-1, res= 0;
        while (lo <= hi) {
            int mid = (lo +hi)/2;

            if(dp[mid]<val) {
                res = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return res+1;
    }


    /*

     */
    public int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        RussianDollEnvelopes r = new RussianDollEnvelopes();
        System.out.println(r.maxEnvelopes(envelopes));
    }
}
