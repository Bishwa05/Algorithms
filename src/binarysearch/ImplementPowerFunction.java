package binarysearch;

/**
 *
 * Implement pow(x, n) % d.
 *
 * In other words, given x, n and d,
 *
 * find (xn % d)
 *
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 *
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 *
 * 2^3 % 3 = 8 % 3 = 2.
 *
 *
 */
public class ImplementPowerFunction
{

    public int pow(int x, int n, int d) {
        if(x ==0) return 0;

        if(n ==0) return 1;


        long d1 = d;

        long res=1;
        long a = x;
        while(n>0){
            // If n is odd, multiply x to the result.
            if((n&1)==1) res = (res*a)%d;

            n = n>>1;       // reduce n by half

            a = (a*a)%d;    // Since we have reduce n by half,
            // that's why we have to square x.
        }
        long ans =d1 + res;
        return (int)ans%d;
    }

    public static void main(String arg[]){

    }
}
