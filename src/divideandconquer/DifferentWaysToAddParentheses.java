package divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Leetcode
 * 241. Different Ways to Add Parentheses
 *
 *
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 */
public class DifferentWaysToAddParentheses {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);

        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!isOperator(c)) {
                continue;
            }

            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));

            for (int num1 : left) {
                for (int num2 : right) {
                    int val = calculate(num1, num2, c);
                    result.add(val);
                }
            }
        }

        // only contains one number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        map.put(input, result);
        return result;
    }

    private int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch(operator) {
            case '+' : result = num1 + num2;
                break;

            case '-' : result = num1 - num2;
                break;

            case '*' : result = num1 * num2;
                break;
        }

        return result;
    }

    private boolean isOperator(char operator) {
        return (operator == '+') || (operator == '-') || (operator == '*');
    }

    public static void main(String args[]) {
        DifferentWaysToAddParentheses d = new DifferentWaysToAddParentheses();
        List res = d.diffWaysToCompute("2*3-4*5");
        res.forEach(e -> System.out.println(e));


    }
}
