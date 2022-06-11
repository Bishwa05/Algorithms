package array;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * Leetcode 1658. Minimum Operations to Reduce X to Zero
 *
 */
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums) sum+=num;

        int maxLength = -1, currSum = 0;
        for(int l = 0, r = 0; r< nums.length; r++ ){
            currSum += nums[r];
            while (l<=r && currSum > sum-x) currSum -= nums[l++];
            if(currSum == sum -x) maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

}
