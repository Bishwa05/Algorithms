package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode
 * 78. Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List interimList = new ArrayList();
        findSubset(0, nums.length, interimList, nums);
        return result;
    }

    public void findSubset(int start, int end, List interimList, int[] nums) {
        result.add(new ArrayList<>(interimList));

        for(int i=start; i<end; i++) {
            interimList.add(nums[i]);
            findSubset(i+1, end, interimList, nums);
            interimList.remove(interimList.size()-1);
        }
    }

    public static void main(String arg[]) {
        Subsets s = new Subsets();
        int[] arr = {1,2,3};
        List<List<Integer>> l = s.subsets(arr);
        l.forEach(u -> {u.forEach(r-> System.out.print(r));
        System.out.println();
            });
    }
}
