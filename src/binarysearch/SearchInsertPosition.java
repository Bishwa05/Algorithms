package binarysearch;

/**
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 *
 * Input: nums = [1], target = 0
 * Output: 0
 *
 */
public class SearchInsertPosition
{
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high && low >=0 && high < nums.length){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;

            if(mid == nums.length -1 && nums[mid]<target) return mid+1;

            if(mid ==0 && nums[mid]>target) return 0;

            if(nums[mid]<target){
                if(nums[mid+1]>target) return mid +1;
                low = mid+1;
            } else {
                if(nums[mid-1]<target) return mid;
                high = mid -1;
            }

        }
        return -1;
    }
}
