package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * The isSubsetSum problem can be divided into two subproblems
 *  a) isSubsetSum() without considering last element
 *     (reducing n to n-1)
 *  b) isSubsetSum considering the last element
 *     (reducing sum/2 by arr[n-1] and n to n-1)
 * If any of the above the above subproblems return true, then return true.
 * isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
 *                               isSubsetSum (arr, n-1, sum/2 - arr[n-1])
 *
 *
 */
public class PartitionEqualSubsetSum {

    /**
     *
     * Recursive approach
     */
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
        }

        if((sum % 2)!=0) return false;

        return isSubsetSum(nums, nums.length, sum/2);
    }

    public boolean isSubsetSum(int[] nums, int n, int sum){
        if(sum==0) return true;

        if(n ==0 && sum != 0) return false;

        if(nums[n-1] > sum)
            return isSubsetSum(nums, n-1, sum);

        return isSubsetSum(nums, n-1, sum) ||
            isSubsetSum(nums, n-1, sum- nums[n-1]);
    }

    /**
     * DP with Memoization
     *
     */
    public boolean canPartitionMemo(int[] nums){
        boolean counter = false;
        int sum =0;
        for(int i: nums){
            sum +=i;
        }
        if(sum%2 != 0){
            return counter;
        }
        Map<String, Boolean> map = new HashMap<>();

        counter = helper(nums, nums.length-1, sum/2, map);
        return counter;
    }

    public boolean helper(int[] nums, int n, int sum, Map<String, Boolean> map){
        String keys = sum+" "+n;
        if(sum ==0) return true;

        if(n ==0 && sum != 0) return false;

        if(map.containsKey(keys)){
            return map.get(keys);
        }
        boolean res;

        if(nums[n] > sum){
            res = helper(nums, n-1, sum, map);
            map.put(keys, res);
            return res;
        }

        res = helper(nums, n-1, sum, map)||
        helper(nums, n-1, sum - nums[n], map);
        map.put(keys, res);
        return res;

    }


    /**
     *
     * Bottom up approach which is quite difficult to write.
     */

    public boolean canPartitionDP(int[] nums) {

        int sum =0;
        for(int i : nums){
            sum+=i;
        }

        if(sum%2 !=0) return false;
        Arrays.sort(nums);
        int half = sum/2;

        boolean[][] dp = new boolean[nums.length+1][half+1];
        dp[0][0] = true;
        for(int i=1; i<=nums.length; i++) {
            for(int j=1; j<=half; j++) {
                dp[i][j] = dp[i-1][j] || (j >=nums[i-1] && dp[i-1][j-nums[i-1]]);
            }
        }
        return dp[nums.length][half];

        /**
         * boolean[] dp = new boolean[half+1];
         *         dp[0] = true;
         *         for(int i=1; i<=nums.length; i++) {
         *             for(int j=target; j >=0 ;j--) {
         *                 dp[j] = dp[j] || (j >=nums[i-1] && dp[j-nums[i-1]]);
         *             }
         *         }
         *         return dp[half];
         */
    }

    public static void main(String arg[]) {
        int[] n = {1,2,3,4,5,6,7};
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(n));

    }
}
