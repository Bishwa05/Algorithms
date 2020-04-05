package greedy;

/**
 * Given an array of non-negative integers, you are initially
 * positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump
 * length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpCanReachEnd {

    public static boolean canReachEnd(int []nums, int start, int count) {
        if((nums[start]+ start+1)>= nums.length) {
            return true;
        }

        if(start <nums.length && count<= nums[start])
            return canReachEnd(nums,++start,++count);

        return false;
    }

    public static boolean canJump(int []nums){

        if(nums[0]==0) {
            return false;
        }

        return canReachEnd(nums,0, 1);
    }

    public static void main(String arg[]) {
        int arr[] = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
