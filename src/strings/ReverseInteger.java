package strings;

/**
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {
    static int result =0;
    public static int getReverseInt(int val) {

        if (val != 0) {

        int rem = val % 10;
        val = val / 10;
        result = val != 0 ?(result + rem) * 10: (result + rem);
        getReverseInt(val);
        }

        return result;
    }

    public static int reverseApproach2(int val) {
        boolean negative = false;
        if(val <0){
            negative = true;
            val = val *-1;
        }

        long reverse =0;
        while(val>0) {
            reverse = reverse*10 + val%10;
            val = val/10;
        }

        if (reverse > Integer.MAX_VALUE)
            return 0;
        return negative?(int)(-1* reverse) : (int) reverse;

    }

    public static void main(String arg[]) {
        int val = -123;
        // System.out.println(getReverseInt(val));
        System.out.println(reverseApproach2(val));

    }
}
