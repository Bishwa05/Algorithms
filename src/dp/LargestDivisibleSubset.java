package dp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 368. Largest Divisible Subset
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 *
 */
public class LargestDivisibleSubset
{
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length, maxLen =0, index =0;
        int dp[] = new int[n];

        if(n ==0) return new ArrayList<>();
        Arrays.sort(nums);

        for(int i =0; i<n; i++){
            for(int j =0; j<i; j++){
                if(nums[i]% nums[j] ==0)
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(maxLen<dp[i]){
                maxLen = dp[i];
                index =i;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = index; i>=0; i--){
            if(nums[index] % nums[i]==0 && dp[index]- dp[i] <=1){
                list.add(nums[i]);
                index = i;
            }
        }
        return list;
    }

    public static void main (String[] args)
    {
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        int[] nums = {1,2,3};
        l.largestDivisibleSubset(nums).forEach(
            e -> System.out.println(e)
        );
    }
}
