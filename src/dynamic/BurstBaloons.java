package dynamic;

/**
 * Leetcode hard
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 */
public class BurstBaloons {

    public int maxCoins(int[] A) {
        if(A.length ==0) return 0;
        int n = A.length;
        int[][] dp = new int[n][n];

        for(int L =n-1; L>=0; L--){
            for(int R = L; R<n; R++){
                for(int i= L; i<=R; i++){
                    dp[L][R] = Math.max(dp[L][R],
                            A[i]*(L>0?A[L-1]:1)*(R==n-1?1:A[R+1])
                            + (L<=i-1?dp[L][i-1]:0) + (i+1 <= R? dp[i+1][R]:0));
                }
            }
        }
        return dp[0][n-1];

    }

    public static void main(String arg[]){
        int[] nums = {3,1,5,8};
        BurstBaloons b = new BurstBaloons();
        System.out.println(b.maxCoins(nums));
    }
}
