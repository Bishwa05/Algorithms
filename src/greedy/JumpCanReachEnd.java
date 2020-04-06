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

    public static boolean canReachEnd(int []nums, int position) {
        if(position == nums.length-1) {
            return true;
        }

        int longJump = Math.min(position+nums[position],nums.length-1);
        int nextPosition = position+1;
        while(nextPosition<=longJump){
            if(canReachEnd(nums,nextPosition)) return true;
            nextPosition++;
        }

        return false;
    }
    //Backtracking approach

    /**
     * Time complexity : O(2^n)
     * Space complexity O(n).
     * @param nums
     * @return boolean
     */
    public static boolean canJump(int []nums){
        if(nums[0]==0 && nums.length >1)
            return false;
        return canReachEnd(nums,0);
    }

    /**
     * Greedy approach
     * Time complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int []nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String arg[]) {
        int arr[] = {2,3,1,1,4};
        //int arr[] ={3,2,1,0,4};

        //int arr[] ={0};
        System.out.println(canJump2(arr));
    }
}
