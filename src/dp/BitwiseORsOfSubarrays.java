package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode
 * 898. Bitwise ORs of Subarrays
 * Let's try to speed up a brute force answer. Evidently, the brute
 * force approach is to calculate every result result(i, j) = A[i] | A[i+1] | ... | A[j].
 * We can speed this up by taking note of the fact that result(i, j+1) = result(i, j) | A[j+1].
 * Naively, this approach has time complexity O(N^2) , where N is the length of the array.
 * Actually, this approach can be better than that. At the kth step,
 * say we have all the result(i, k) in some set cur.
 * Then we can find the next cur set (for k -> k+1) by
 * using result(i, k+1) = result(i, k) | A[k+1].
 * However, the number of unique values in this set cur is at most 32,
 * since the list result(k, k), result(k-1, k), result(k-2, k), ... is
 * monotone increasing, and any subsequent values that are different
 * must have more 1s in it's binary representation (to a maximum of 32 ones).
 */

public class    BitwiseORsOfSubarrays
{
    public int subarrayBitwiseORs (int[] A)
    {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x : A) {
            Set<Integer> cur2 = new HashSet();
            for (int y : cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();

    }

    public static void main (String arg[])
    {
        int[] nums = { 1, 2, 4 };
        BitwiseORsOfSubarrays b = new BitwiseORsOfSubarrays();
        System.out.print(b.subarrayBitwiseORs(nums));

    }
}
