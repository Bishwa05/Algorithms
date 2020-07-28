package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode
 * 898. Bitwise ORs of Subarrays
 *
 *
 *
 * The solution is straight forward,
 * while you may worry about the time complexity up to O(N^2)
 * However, it's not the fact.
 * This solution has only O(30N)
 * The reason is that, B[0][i] >= B[1][i] >= ... >= B[i][i].
 * B[0][i] covers all bits of B[1][i]
 * B[1][i] covers all bits of B[2][i]
 * ....
 * There are at most 30 bits for a positive number 0 <= A[i] <= 10^9.
 * So there are at most 30 different values for B[0][i], B[1][i], B[2][i], ..., B[i][i].
 * Finally cur.size() <= 30 and res.size() <= 30 * A.length()
 * In a worst case, A = {1,2,4,8,16,..., 2 ^ 29}
 * And all B[i][j] are different and res.size() == 30 * A.length()
 *
 *
 */

public class BitwiseORsOfSubarrays
{
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        res.add(A[0]);
        prev.add(A[0]);

        for(int i=1; i<A.length; i++){
            Set<Integer> curr = new HashSet<>();
            res.add(A[i]);
            curr.add(A[i]);

            for(int a : prev){
                curr.add(a| A[i]);
                res.add(a|A[i]);
            }
            prev = curr;
        }

        return res.size();

    }

    public static void main(String arg[]) {
        int[] nums = {1,2,4};
        BitwiseORsOfSubarrays b = new BitwiseORsOfSubarrays();
        System.out.print(b.subarrayBitwiseORs(nums));

    }
}
