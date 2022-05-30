package bitmanipulation;

/**
 *
 * https://leetcode.com/problems/divide-two-integers/
 * leetcode : 29. Divide Two Integers
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor ==1) {
            return dividend;
        }
        if(divisor == -1){
            return dividend == Integer.MIN_VALUE?Integer.MAX_VALUE: -dividend;
        }
        boolean isNegative = (dividend >0 && divisor<0)|| (dividend <0 && divisor >0);
        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);
        int res =0;
        for(int bit = Integer.SIZE; bit>=0 && longDividend >= longDivisor; bit-- ){
            if(longDividend >=(longDivisor << bit)){
                res |= (1<<bit);
                longDividend -= (longDivisor << bit);
            }
        }
        return isNegative? -res :res;
    }

}
