package monotonic_stack;

import java.util.Stack;

/**
 * Given an array of integers temperatures representing daily temperatures, calculate how many days you have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * Examples
 * Example 1
 * Input: temperatures = [70, 73, 75, 71, 69, 72, 76, 73]
 * Output: [1, 1, 4, 2, 1, 1, 0, 0]
 * Explanation: The first day's temperature is 70 and the next day's temperature is 73 which is warmer. So for the first day, you only have to wait for 1 day to get a warmer temperature. Hence, the first element in the result array is 1. The same process is followed for the rest of the days.
 *
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack();
            int[] res = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    // While the stack is not empty and the current temperature is higher
                    // than the temperature at the index stored at the top of the stack:
                    int index = stack.pop(); // Pop the top index from the stack.
                    res[index] = i - index; // Calculate the number of days until warmer temperature.

                }
                stack.push(i);
            }
    return res;
    }
}
