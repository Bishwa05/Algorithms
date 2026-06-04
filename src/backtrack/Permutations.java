package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations
{
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result){
        if(start == nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i = start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     *
     * Another way
     */

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currList, boolean[] used, List<List<Integer>>result) {


        if (nums.length == currList.size()) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currList.add(nums[i]);
                used[i] = true;
                backtrack(nums, currList, used, result);
                used[i] = false;
                currList.remove(currList.size() -1);
            }
        }
    }

}
