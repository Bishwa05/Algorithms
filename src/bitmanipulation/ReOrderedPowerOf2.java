package bitmanipulation;

/**
 * Leetcode 869. Reordered Power of 2
 *
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Example 2:
 *
 * Input: 10
 * Output: false
 * Example 3:
 *
 * Input: 16
 * Output: true
 *
 *
 * We can check whether two numbers have the same digits by comparing the count of their digits. For example, 338 and 833 have the same digits because they both have exactly two 3's and one 8.
 * Since NN could only be a power of 2 with 9 digits or less (namely, 2^0, 2^1, \cdots, 2^292
 * 0
 *  ,2
 * 1
 *  ,⋯,2
 * 2
 *  9), we can just check whether NN has the same digits as any of these possibilities.
 * Time Complexity: O(\log^2 N)O(log
 * 2
 *  N). There are \log NlogN different candidate powers of 2, and each comparison has O(\log N)O(logN) time complexity.
 * Space Complexity: O(\log N)O(logN).
 */
public class ReOrderedPowerOf2
{
    public boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for(int i =0; i<32; i++)
            if(counter(1<<i)==c) return true;

        return false;
    }

    public long counter(int N){
        long res = 0;
        for(; N>0; N/=10){
            res += (int)Math.pow(10, N%10);
        }
        return res;
    }

    public static void main(String arg[]){
        ReOrderedPowerOf2 r = new ReOrderedPowerOf2();
        System.out.println(r.reorderedPowerOf2(10));
    }
}
