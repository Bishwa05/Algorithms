package monotonic_stack;

import java.util.Stack;

/**
 * Problem Statement
 *
 * Given a non-negative integer represented as a string num and an integer k, delete k digits from num to obtain the smallest possible integer. Return this minimum possible integer as a string.
 *
 * Examples
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: The digits removed are 4, 3, and 2 forming the new number 1219 which is the smallest.
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Removing the leading 1 forms the smallest number 200.
 *
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();

        for (char digit : num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && digit < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        // Truncate the remaining K digits
        for(int i=0; i<k; ++i) {
            stack.pop();
        }

        // Convert Stack to String
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        // Remove any leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        // If the String is empty return "0"
        return (sb.isEmpty()) ? "0" : sb.toString();
    }
}
