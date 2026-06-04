package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationII
{
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result){
        if(start == nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i =start; i<nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);

            swap(nums, i, start);
            helper(start+1, nums,result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * Another way sorting
     */

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to group duplicates together
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            // Skip duplicate numbers if the previous identical number wasn't used yet
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            current.add(nums[i]);

            backtrack(result, current, nums, visited);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
