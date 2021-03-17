package binarysearch;

/**
 * Leetcode
 * 81. Search in Rotated Sorted Array II
 *
 */
public class SearchInRotatedArrayII
{
    public boolean search(int[] nums, int target) {
        if (null == nums || 0 == nums.length)
            return false;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            // to avoid duplicates
            while (lo < hi && nums[lo] == nums[lo + 1])
                ++lo;
            while (lo < hi && nums[hi] == nums[hi - 1])
                --hi;


            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return true;

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
        return false;
    }

    public static void main(String arg[]){
        SearchInRotatedArrayII s = new SearchInRotatedArrayII();
        int nums[] = {1,0,1,1,1};
        System.out.println(s.search(nums, 0));
    }
}
