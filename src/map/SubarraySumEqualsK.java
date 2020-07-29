package map;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K
 * Leetcode.
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]) {
        SubarraySumEqualsK s  = new SubarraySumEqualsK();
        int[] nums = {1,1,1};
        int k = 2;
        s.subarraySum(nums,k);
    }
}
