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

    public int search(int[] nums, int target){
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


    public int search2(int[] nums, int target) {
        if (null == nums || 0 == nums.length)
            return -1;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;

            // We are using mid of the array as well to find the index
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (target <= nums[hi] && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String arg[]){
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int nums[] = {4,5,7,0,1,2};
        System.out.println(s.search2(nums, 0));
    }
}
