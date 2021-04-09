package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *  Leetcode 90. Subsets II
 *
 *
 *  Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class SubSetII
{
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> interimList = new ArrayList();
        findSubset(0, interimList, nums);
        return result;
    }

    public void findSubset(int start, ArrayList<Integer> interimList, int[] nums) {

        result.add(new ArrayList<>(interimList));

        Integer prev = null;

        for(int i=start; i<nums.length; i++) {
            if(prev == null || prev != nums[i]){
                interimList.add(nums[i]);
                findSubset(i+1, interimList, nums);
                interimList.remove(interimList.size()-1);
            }
            prev = nums[i];
        }
    }
}
