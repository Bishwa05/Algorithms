package strings;

/**
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int num) {

        if(num ==0) return true;

        if(num <0 || num%10 ==0) return false;

        int reverse =0;
        while(num>reverse){
            int rem = num%10;
            num = num/10;

            reverse = reverse *10 +rem;

        }

        if(num == reverse || num == reverse/10){
            return true;
        } else{
            return false;
        }

    }

    public static void main(String arg[]) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }
}
