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
}
