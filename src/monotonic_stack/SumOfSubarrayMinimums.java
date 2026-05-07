package monotonic_stack;

import java.util.Stack;

/**
 *
 * Given an array of integers arr, return the sum of the minimum values from all possible contiguous subarrays within arr. Since the result can be very large, return the final sum modulo (109 + 7).
 *
 * Examples
 * Example 1:
 *
 * Input: arr = [3, 1, 2, 4, 5]
 * Expected Output: 30
 * Explanation:
 * The subarrays are: [3], [1], [2], [4], [5], [3,1], [1,2], [2,4], [4,5], [3,1,2], [1,2,4], [2,4,5], [3,1,2,4], [1, 2, 4, 5], [3, 1, 2, 4, 5].
 * The minimum values of these subarrays are: 3, 1, 2, 4, 5, 1, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Summing these minimums: 3 + 1 + 2 + 4 + 5 + 1 + 1 + 2 + 4 + 1 + 1 + 2 + 1 + 1 + 1 = 30
 *
 */

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long res = 0;
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array plus one extra iteration for a sentinel.
        for (int currIndex = 0; currIndex <= n; currIndex++) {
            // If we reached the end, use 0 as a sentinel value; otherwise, use the current element.
            // It helps to process all remaining elements in the stack.
            int currElement = (currIndex == n) ? 0 : arr[currIndex];

            // Process elements in the stack while the current element is smaller than the element at the top.
            // Here, we maintain monotonic increasing stack.
            while (!stack.empty() && arr[stack.peek()] > currElement) {
                // Pop the index whose corresponding element is greater than currentElement.
                int minIndex = stack.pop();
                // Determine the previous index from the stack; if the stack is empty, use -1.
                int prevIndex = stack.empty()? -1 : stack.peek();

                // Calculate the number of subarrays where arr[minIndex] is the minimum:
                // (minIndex - previousIndex) gives the count of subarrays ending at minIndex,
                // and (currentIndex - minIndex) gives the count of subarrays starting at minIndex
                // that can extend until currentIndex.
                int countSubarrays = (minIndex - prevIndex) * (currIndex - minIndex);

                // Add the contribution of arr[minIndex] for these subarrays to the result.
                res = (res + (long)arr[minIndex] * countSubarrays % MOD) % MOD;
            }
            // Push the current index onto the stack for further processing.
            stack.push(currIndex);
        }
        return (int) (res % MOD);
    }
}
