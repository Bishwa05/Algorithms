package binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return 0
 *
 * **Example : **
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return 2.
 *
 * Similar Question
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 */
public class CountElementOccurence
{
    public int findCount(final List<Integer> A, int B) {
        int left = binarySearch(A, B, true);
        if(left<0) return 0;
        int right = binarySearch(A, B, false);
        return right - left +1;
    }

    private int binarySearch(List<Integer>A, int target, boolean leftmost){

        int lo =0;
        int hi =A.size() -1;
        int idx = -1;
        while(lo<=hi) {
            int mid = (lo + hi) >>> 1; // avoids overflow

            if (target> A.get(mid)){
                lo = mid+1;
            } else if(target< A.get(mid)){
                hi = mid-1;
            } else{
                idx = mid;
                if(leftmost){
                    hi = mid -1;
                } else{
                    lo = mid+1;
                }
            }
        }
        return idx;
    }

    public static void main(String arg[]){
        CountElementOccurence c = new CountElementOccurence();
        List x = Arrays.asList(5, 7, 7, 8, 8, 10);
        System.out.println(c.findCount(x,7));
    }
}
