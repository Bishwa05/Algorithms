package monotonic_stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> charStack = new Stack<>();
        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            if(!charStack.isEmpty() && charStack.peek() == c) {
                charStack.pop();
            } else {
                charStack.push(c);
            }
        }
        // Join the stack to a string
        StringBuilder result = new StringBuilder();
        for (Character c : charStack) {
            result.append(c);
        }
        return result.toString();
    }
}
