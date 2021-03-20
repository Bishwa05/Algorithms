package dp;

/**
 * Leetcode 334. Increasing Triplet Subsequence
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 */
public class IncreasingTripletSubsequence
{
    /**
     * Brute force
     */
    public boolean increasingTriplet(int[] nums) {

        int n = nums.length;
        if(n<3) return false;

        for(int i =0; i< n-2; i++){
            for(int j = i +1; j< n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i]< nums[j] && nums[j] < nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    /**
     * DP
     */
    public boolean increasingTripletDP(int nums[])
    {

        int n = nums.length;
        int lis[] = new int[n];

        /* Initialize LIS values for all indexes */
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if (lis[i] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String arg[]){
        int nums[] = {2, 1, 5, 0, 4, 6};
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        System.out.println(i.increasingTripletDP(nums));

    }
}
