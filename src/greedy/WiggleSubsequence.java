package greedy;

/**
 *
 * 376. Wiggle Subsequence
 *
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 *
 */
public class WiggleSubsequence
{
    public int calculate(int[] nums, int index, boolean isUp){
        int maxCount =0;
        for(int i = index+1; i< nums.length; i++){
            if((isUp && nums[i] > nums[index])||
                (!isUp && nums[i]< nums[index])){
                maxCount = Math.max(maxCount, 1+ calculate(nums, i, !isUp));
            }
        }
        return maxCount;
    }
    public int wiggleMaxLength(int[] nums){
        if(nums.length<2) {
            return nums.length;
        }
        return 1 + Math.max(calculate(nums, 0, true),
            calculate(nums, 0, false));
    }


    public int wiggleMaxLengthGreedy(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }
}
