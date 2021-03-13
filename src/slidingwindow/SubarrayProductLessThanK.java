package slidingwindow;

/**
 *
 * 713. Subarray Product Less Than K
 *
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 */
public class SubarrayProductLessThanK
{
    public int numSubarrayProductLessThaK(int nums[], int k){
        if(k <=1) return 0;
        int prod = 1, ans = 0, left =0;

        for(int right =0; right < nums.length; right++){
            prod *= nums[right];
            while(prod>=k) prod /= nums[left++];
            ans += right -left+1;
        }
        return ans;
    }

}
