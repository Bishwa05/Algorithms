package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 494
 *
 * Ways to  reach to a target Sum.
 */
public class TargetSum {

    private int findTargetSum(int[] nums, int S, int i, int sum){
        //Base condition
        if(i==nums.length){
            if(S== sum) return 1;
            else return 0;
        }


        return findTargetSum(nums, S, i+1, sum+nums[i]) +
                findTargetSum(nums, S, i+1, sum-nums[i]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSum(nums, S, 0, 0);
    }


    public int findTargetSumWaysMemo(int[] nums, int S) {
        Map<Integer, Integer>map = new HashMap<>();
        return findTargetSum(nums, S, 0, 0, map);

    }

    public int findTargetSum(int nums[], int S, int i, int  sum, Map<Integer, Integer> map){

        //Base condition
        if(i==nums.length){
            if(S== sum) return 1;
            else return 0;
        }
        int left =0;
        int right =0;
        if(!map.containsKey(sum+nums[i])){
            left = findTargetSum(nums, S, i+1, sum+nums[i]);
            map.put(sum+nums[i], left);
        }
        if(!map.containsKey(sum-nums[i])){
            right = findTargetSum(nums, S, i+1, sum-nums[i]);
            map.put(sum-nums[i], right);
        }
        return map.get(sum+nums[i]) + map.get(sum-nums[i]);
    }

    public int findTargetSumWaysBottomUp(int[] nums, int S){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // S and sum should be either both odd or both even, since odd +(-) odd = even
        // even +(-) even = even, odd +(-) even = odd, we can find that it is not related
        if (sum < S || (S + sum) % 2 == 1) {
            return 0;
        }

        // (S + sum) / 2 actually removed the element with negative sign in S
        // The problem reduced to, subsetSumWay, i.e. how many ways subsequence
        // sum up to target.
        return subsetSumWays(nums, (S + sum) / 2);
    }


    private int subsetSumWays(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i =0; i<nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] =dp[j]+ dp[j - nums[i]];
            }
        }

        return dp[target];
    }



    public static  void main(String arg[]){
        TargetSum ts = new TargetSum();
        int [] nums ={1, 1, 1, 1, 1};
        int S = 3;
//        System.out.println(ts.findTargetSumWays(nums, S));
//        System.out.println(ts.findTargetSumWaysMemo(nums, S));
//        System.out.println(ts.findTargetSumWaysBottomUp(nums, S));

        System.out.println(ts.findTargetSumWaysBottomUp(nums, S));
    }


}
