package dp;

/**
 * Leetcode
 * 213. House Robber II
 */

public class HouseRobberII {
    public int robHelper(int[] nums, int i, int j){
        if(i==j){
            return nums[i];
        }

        int[] dp = new int[nums.length];
        dp[i]=nums[i];
        dp[i+1]=Math.max(nums[i+1], dp[i]);

        for(int k=i+2; k<=j; k++){
            dp[k]=Math.max(dp[k-1], dp[k-2]+nums[k]);
        }

        return dp[j];
    }

    public int rob(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int max1 = robHelper(nums, 0, nums.length-2);
        int max2 = robHelper(nums, 1, nums.length-1);

        return Math.max(max1, max2);
    }

    public static void main(String args[]) {
        //int nums[] = {2,7,9,3,1}; //--11
        int nums[] = {1,3,1,3,100};
        HouseRobberII h = new HouseRobberII();
        System.out.println(h.rob(nums));
    }
}
