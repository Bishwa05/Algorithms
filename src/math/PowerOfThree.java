package math;

public class PowerOfThree
{

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeMath(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThreeLog(int n) {
        if (n <= 0) return false;
        double d = Math.log(n)/Math.log(3);
        return Math.pow(3, d) == n;
    }

    /**
     * 3 ^ 19 =1162261467
     */
    public boolean isPowerOfThreeupperBound(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


}
