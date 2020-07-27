package binarysearch;

/**
 * Leetcode 153. Find Minimum in Rotated Sorted Array
 *
 *
 * If we pick the middle element, we can compare the middle element
 * with the leftmost (or rightmost) element. If the middle element is less than leftmost,
 * the left half should be selected; if the middle element is greater than the leftmost
 * (or rightmost), the right half should be selected. Using recursion or iteration,
 * this problem can be solved in time log(n).
 *
 */

public class FindMinimumInRotatedSortedArray
{
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    public int findMin(int[] num, int left, int right)
    {
        if (right == left) {
            return num[left];
        }
        if (right == left + 1) {
            return Math.min(num[left], num[right]);
        }
        // 3 3 1 3 3 3

        int middle = (right - left) / 2 + left;
        // already sorted
        if (num[right] > num[left]) {
            return num[left];
            //right shift one
        }
        // To handle duplicate in input array
        // else if (num[right] == num[left]) {
        //     return findMin(num, left + 1, right);
        //     //go right
        // }
        else if (num[middle] >= num[left]) {
            return findMin(num, middle, right);
            //go left
        }
        else {
            return findMin(num, left, middle);
        }
    }

    public int findMin2(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int i=0;
        int j=nums.length-1;

        while(i<=j){
            if(nums[i]<=nums[j])
                return nums[i];

            int m=(i+j)/2;

            if(nums[m]>=nums[i]){
                i=m+1;
            }else{
                j=m;
            }
        }

        return -1;
    }
}
