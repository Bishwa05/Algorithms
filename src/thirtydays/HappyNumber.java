package thirtydays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 */
public class HappyNumber {

    public static int doCalculate(String N) {
        int val =0;
        for(char x : N.toCharArray()){
            int ch = x-48;
            val += ch*ch;
        }
        return val;
    }

    public static int doCalculate2(int N) {
        int val =0;
        int n=0;
        while(N>0){
            n = N%10;
            N = N/10;
            val += n*n;
        }
        return val;
    }

    public static boolean findHappyNumber(int num) {

//        int val = doCalculate(String.valueOf(num));
//        Set valSet = new HashSet<>();
//        while(val !=1 && valSet.add(val)){
//            val = doCalculate(String.valueOf(val));
//        }
//        return (val==1)?true:false;

        int val = doCalculate2(num);
        Set valSet = new HashSet<>();
        while(val !=1 && valSet.add(val)){
            val = doCalculate2(val);
        }
        return (val==1)?true:false;
    }

    public static void main(String args[]){
        int num = 19;

        System.out.println(findHappyNumber(num));
    }
}
