package dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int oddSum =0;
        int evenSum =0;


        for(int i =0; i< nums.length; i++){
            if(i%2!=0){
                oddSum += nums[i];
                oddSum = (oddSum>evenSum)?oddSum:evenSum;
            } else{
                evenSum += nums[i];
                evenSum = (evenSum>oddSum)?evenSum:oddSum;
            }
        }
        return (oddSum>evenSum)?oddSum:evenSum;

    }
}
