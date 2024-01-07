package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 *     For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 *     For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 *
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 *     For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 *
 */
public class ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;

        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i; j++) {
                long diff = (long)nums[i] - nums[j];

                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                int diffInt = (int) diff;

                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);
                if (dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    count += dp[j].get(diffInt);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,4,6,8,10};
        ArithmeticSlicesIISubsequence ams = new ArithmeticSlicesIISubsequence();
        ams.numberOfArithmeticSlices(nums);
    }
}
