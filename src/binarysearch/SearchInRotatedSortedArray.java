package binarysearch;

/**
 * Leetcode
 * 33. Search in Rotated Sorted Array
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray
{

    public int serach(int[] nums, int target){
        int smallestIndex = -1;
        int n = nums.length;

        int l =0, r = n-1;

        while(l <=r){
            int mid = (l+r)>>1;
            if(nums[mid]> nums[n-1]){
                l = mid+1;
            } else{
                smallestIndex = mid;
                r = mid-1;
            }
        }

        l =0;
        r = n-1;

        while(l <= r){
            int mid = (l+r)>>1;
            int newIndex = (mid + smallestIndex)%n;

            if(nums[newIndex] < target){
                l = mid+1;
            } else if(nums[newIndex] > target){
                r = mid -1;
            } else{
                return newIndex;
            }
        }
        return -1;
    }
}
