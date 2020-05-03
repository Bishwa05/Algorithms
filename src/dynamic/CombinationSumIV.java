package dynamic;

import java.util.Arrays;

/**
 * 377 Leetcode
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 */
public class CombinationSumIV {


    /**
     * Similar to coin change.
     */
    public int combinationSum4(int[] nums, int target) {
        if(target==0){
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;

    }

    public int combinationSum4BottomUp(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;

        int[] dp = new int[target+1];

        dp[0]=1;

//        for(int i=0; i<=target; i++){
//            for(int num: nums){
////                if(i+num<=target){
////                    dp[i+num]= dp[i+num] + dp[i];
////                }
//                if(i>=num){
//                    dp[i] = dp[i]+  dp[i-num];
//                }
//            }
//        }

        for(int i=0; i<=target; i++){
            for(int j =0; j <nums.length; j++){
                if(i>=nums[j]){
                    dp[i] = dp[i]+  dp[i-nums[j]];
                }
            }
        }

        return dp[target];

    }



    int [] dp;
    public int combinationSum4Memo(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public static  void main(String arg[]){
        int [] nums = {1, 2, 3};
        int target =4;
        CombinationSumIV cs = new CombinationSumIV();
        System.out.println(cs.combinationSum4BottomUp(nums, target));
       //System.out.println(cs.combinationSum4(nums, target));

    }
}
