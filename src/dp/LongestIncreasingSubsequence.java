package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Leetcode 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence
{



    /* lis() returns the length of the longest increasing
       subsequence in arr[] of size n */
    static int lis (int arr[], int n)
    {
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    /**
     *
     * Quadratic DP
     *
     * for(int i =0; i<n; i++){
     *     for(int j = i+1; j<n; j++){
     *         if(nums[i]< nums[j]){
     *             dp[j] = max(dp[j], dp[i]+1);
     *         }
     *     }
     * }
     *
     */

    /**
     * Binary Search
     */
    public static int lisBS(int[] arr, int n){

        int[] dp = new int[arr.length];
        int len = 0;
        for (int num : arr) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;

    }

    public static int lengthOfLISBS(int[] nums) {
        int[] dp = new int[nums.length]; //'dp' array will be an array with increasing order.
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (dp[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            dp[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    /**
     * DFS
     */
    public int lengthOfLLIS(int[] nums){
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthOfLIS(int[] nums, int prev, int curPos){
        if(curPos == nums.length) return 0;

        int taken = 0;
        if(nums[curPos] > prev){
            taken = 1 + lengthOfLIS(nums, nums[curPos], curPos +1);
        }
        int notTaken = lengthOfLIS(nums, prev, curPos+1);
        return Math.max(taken, notTaken);
    }

    public static void main (String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lengthOfLISBS(arr) + "\n");
    }
}
