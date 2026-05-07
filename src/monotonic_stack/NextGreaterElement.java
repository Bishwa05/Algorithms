package monotonic_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given two integer arrays nums1 and nums2, return an array answer such that answer[i] is the next greater number for every nums1[i] in nums2.
 *
 * The next greater element for an element x is the first element to the right of x that is greater than x. If there is no greater number, output -1 for that number.
 *
 * The numbers in nums1 are all present in nums2.
 *
 * Examples
 *
 * Input: nums1 = [4,2,6], nums2 = [6,2,4,5,3,7]
 * Output: [5,4,7]
 * Explanation: The next greater number for 4 is 5, for 2 is 4, and for 6 is 7 in nums2.
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();

        // Process each number in nums2
        for (int num : nums2) {
            // Pop elements from the stack that are smaller than current number
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num); // Remember the next greater element for num
            }
            // Push current number onto stack
            stack.push(num);
        }

        // Map the remaining numbers on the stack to -1
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();
        int[] nums1 = {4,2,6};
        int[] nums2 = {6,2,4,5,3,7};
        int[] output = solution.nextGreaterElement(nums1, nums2);
        for (int num : output)
            System.out.print(num + " ");
        System.out.println();
    }

}
