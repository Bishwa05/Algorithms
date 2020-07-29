package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem can be solved in multiple ways
 *
 * The base condition is : targetSum reached with every iteration.
 */
public class TargetSum {

    // Naive brute force solution. Find every combination this is dfs approach.
    public int targetSum(int[] nums, int T) {
        return targetSum(nums, T, 0, 0);
    }

    private int targetSum(int[] nums, int T, int i, int sum) {
        // When we've gone through every item, see if we've reached our target sum
        if (i == nums.length) {
            return sum == T ? 1 : 0;
        }

        // Combine the possibilites by adding and subtracting the current value
        return targetSum(nums, T, i+1, sum + nums[i])
                + targetSum(nums, T, i+1, sum - nums[i]);
    }


/**     Top down dp programming solution. Like
 0-1 Knapsack, we use a HashMap to save
 space
 */
    public int targetSumMemo(int[] nums, int T) {
        // Map: i -> sum -> value
        Map<Integer, Map<Integer, Integer>> cache =
                new HashMap<>();
        return targetSum(nums, T, 0, 0, cache);
    }

    // Overloaded recursive function
    private int targetSum(int[] nums, int T, int i, int sum,
            Map<Integer, Map<Integer, Integer>> cache)
    {
        if (i == nums.length) {
            return sum == T ? 1 : 0;
        }

        // Check the cache and return if we get a hit
        if (!cache.containsKey(i)) cache.put(i,
                new HashMap<>());
        Integer cached = cache.get(i).get(sum);
        if (cached != null) return cached;

        // If we didn't hit in the cache, compute the value and store to cache
        int toReturn =
                targetSum(nums,T,i+1,sum+nums[i],cache) +
                        targetSum(nums,T,i+1,sum-nums[i],cache);
        cache.get(i).put(sum, toReturn);
        return toReturn;
    }


    public static void main(String arg[]){
        int arr [] = {1, 1, 1, 1, 1};
        int s = 3;
        TargetSum t = new TargetSum();
        System.out.println(t.targetSum(arr, s));
        System.out.println(t.targetSumMemo(arr, s));
    }
}
