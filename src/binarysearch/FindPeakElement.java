package binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 */
public class FindPeakElement
{
    public static int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = (lo+hi)>>>1;
            if(nums[mid]> nums[mid+1]){
                hi = mid;
            } else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
