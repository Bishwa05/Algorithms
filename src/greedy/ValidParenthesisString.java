package greedy;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "(*)"
 * Output: true
 *
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open parenthesis
        int maxOpen = 0; // Maximum possible open parenthesis

        for (char c : s.toCharArray()) {
            if (c == '(') { // ( as open parenthesis
                minOpen++;
                maxOpen++;
            } else if (c ==')') { // ) as close parenthesis
                minOpen--;
                maxOpen--;
            } else {
                // * can be treated as (, ) or ""
                minOpen--;
                maxOpen++;
            }
            // if any point maxOpen is -ve, it means too many )
            if (maxOpen < 0) return false;
            // minOpen should not be -ve as we can nit have unmatched ) without (.
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
