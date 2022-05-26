package bitmanipulation;

/**
 * Leetcode : 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count =0;
        //if(n<0) n= n*-1;
        while(n!=0){
            count++;
            n = n& (n-1);

        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits n = new NumberOf1Bits();
        System.out.println(n.hammingWeight(64));
    }
}
