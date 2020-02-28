package strings;

/**
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class StringToInteger {

    public static int myToI(String str){
        if (str == null){
            return 0;
        }

        if(str.length() ==0){
            return 0;
        }

        str = str.trim();

        boolean isNegative = false;
        int start = 0;

        if(str.charAt(0) == '+' || str.charAt(0) == '-')
            start++;
        if( str.charAt(0)  == '-')
            isNegative = true;

        double result =0;
        for( int i = start; i<str.length(); i++) {
            if(str.charAt(i)<'0' || str.charAt(i)> '9'){
                break;
            }
            int digit = (int)(str.charAt(i) -'0');
            result = result*10 + digit;
        }

        if(isNegative)
            result = -result;

        if(result>Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;

        if(result<Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;

        return (int)result;
    }

    public static void main(String arg[]) {
        String str = "4193   hello";
        System.out.println(myToI(str));
    }
}
