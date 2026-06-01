package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern132 {
    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        Deque<Integer> stack = new ArrayDeque<>();
        int k = -1;
        for(int i = nums.length-1; i>0; i--) {
            if(k>-1 && nums[k]> nums[i]) {
                return true;
            }

            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                k = stack.pop();
            }
            stack.push(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(find132pattern(nums));
        int[] nums2 = {3,1,4,2};
        System.out.println(find132pattern(nums2));
    }
}
