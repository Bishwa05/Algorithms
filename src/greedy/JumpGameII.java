package greedy;

/**
 * Leetcode 45. Jump Game II
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class JumpGameII
{
    public int jump(int[] nums) {
        int len = nums.length;
        if(len ==1) return 0;
        int count =0;
        int max = 0;
        int curPos = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, i + nums[i]);
            if (i == curPos) {
                count++;
                curPos = max;
            }
            if(curPos >= len-1)  return count;
        }
        return 0;
    }


    public static void main(String arg[]){
        JumpGameII j = new JumpGameII();
        int[] nums = {1,0,3,1,4};
        //int[] nums = {2,0,3,1,4};
        System.out.println(j.jump(nums));
    }
}
