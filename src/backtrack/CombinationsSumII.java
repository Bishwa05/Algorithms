package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 40. Combination Sum II
 *
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 *
 *
 */
public class CombinationsSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void findCombinations(int[] candidates, int index, int target, List<Integer>current, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
        }

        if(target<0){
            return;
        }
        for(int i= index; i< candidates.length; i++){
            if(i==index || candidates[i] != candidates[i-1]){
                current.add(candidates[i]);
                findCombinations(candidates,i+1,target-candidates[i], current, result);
                current.remove(current.size()-1);
            }
        }
    }

    public static void main(String arg[]) {
        int[] combination ={10,1,2,7,6,1,5};
        int target =8;
        CombinationsSumII c = new CombinationsSumII();
        c.combinationSum2(combination, target).forEach(e ->{
            e.forEach( f-> System.out.println(f));
        });
    }

}
