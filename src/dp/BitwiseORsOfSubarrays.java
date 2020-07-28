package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode
 * 898. Bitwise ORs of Subarrays
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
