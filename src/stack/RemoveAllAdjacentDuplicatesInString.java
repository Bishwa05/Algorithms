package stack;

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Leetcode 1047. Remove All Adjacent Duplicates In String
 * Input: s = "abbaca"
 * Output: "ca"
 *
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(charArr[0]);
        int n = s.length();
        for(int i = 1; i< n; i++){
            if(!stack.isEmpty()){
                if(charArr[i] == stack.peek()){
                    if(i+1<n && charArr[i+1] == stack.peek()) continue;
                    stack.pop();
                } else {
                    stack.push(charArr[i]);
                }
            } else {
                stack.push(charArr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString r = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(r.removeDuplicates("abbbaca"));
    }
}
