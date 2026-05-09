package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Example 2:
 *
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {
    public List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to
            // create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current
                // element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }


    // DFS approach
    public List<List<Integer>> findSubsetsDFS(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    // Start DFS from the 0th index with an empty temporary list
    dfs(0, nums, new ArrayList<>(), result);
    return result;
    }

    private void dfs(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // 1. Each state of 'current' is a valid subset, so add a copy to the result
        result.add(new ArrayList<>(current));
        // 2. Explore further by picking the next numbers in the array
        for (int i = index; i < nums.length; i++) {
            // [CHOICE] Add the current number
            current.add(nums[i]);
            // [EXPLORE] Move to the next index
            dfs(i +1, nums, current, result);
            // [BACKTRACK] Remove the last number to try a different path
            current.remove(current.size() -1);
        }
    }


    public static void main(String[] args) {
        Subsets sol = new Subsets();
        List<List<Integer>> result = sol.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = sol.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}


