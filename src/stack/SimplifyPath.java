package stack;

import java.util.Stack;

/**
 * Given an absolute file path in a Unix-style file system, simplify it by converting ".." to the previous directory and removing any "." or multiple slashes. The resulting string should represent the shortest absolute path.
 *
 * Examples
 * Example 1
 * Input: path = "/a//b////c/d//././/.."
 * Expected Output: "/a/b/c"
 * Explanation:
 * Convert multiple slashes (//) into single slashes (/).
 * "." refers to the current directory and is ignored.
 * ".." moves up one directory, so "d" is removed.
 * The simplified path is "/a/b/c".
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        // ToDo: Write Your Code Here.
        Stack<String> stack = new Stack<>();

        // Split the input path string using '/' as a delimiter
        for (String p : path.split("/")) {
            if (p.equals("..")) {
                // If the component is '..', pop the last component from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                // If the component is not empty and not '.', push it onto the stack
                stack.push(p);
            }
        }

        // If the result is empty, return '/', otherwise return the simplified path
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }
}
