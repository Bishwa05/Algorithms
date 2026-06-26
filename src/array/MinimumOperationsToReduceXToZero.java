package array;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * Leetcode 1658. Minimum Operations to Reduce X to Zero
 *
 */
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int target = -x, n = nums.length;
        for (int num : nums) target += num;

        if (target == 0) return n;

        int maxLen = 0, curSum = 0, left = 0;

        for (int right = 0; right < n; ++right) {
            curSum += nums[right];
            while (left <= right && curSum > target) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen != 0 ? n - maxLen : -1;
    }

}
