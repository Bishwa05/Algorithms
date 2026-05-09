package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
    public List<List<Integer>> findSubsets(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the
            // subsets added in the previous step
            if (i > 0 && nums[i] == nums[i - 1])
                startIndex = endIndex + 1;
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public List<List<Integer>> findSubsetsDFS(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfs(nums, 0, currList, subsets);
        return subsets;
    }

    private void dfs(int[] nums, int index, List<Integer> currList, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currList));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            currList.add(nums[i]);
            dfs(nums, i+1, currList, subsets);
            currList.remove(currList.size() -1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDuplicates sol = new SubsetsWithDuplicates();
        List<List<Integer>> result = sol.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
        List<List<Integer>> result2 = sol.findSubsetsDFS(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result2);

        result = sol.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
