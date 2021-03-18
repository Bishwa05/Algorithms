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
        int count =0;
        int max = 0;
        for(int i=0; i<=max; i++){
            if(i+nums[i]> max){
                max = i+nums[i];
                count ++;
            }
            if(max >= len-1)  return count;
        }
        return 0;
    }


    public static void main(String arg[]){
        JumpGameII j = new JumpGameII();
        int[] nums = {2,0,3,1,4};
        System.out.println(j.jump(nums));
    }
}
