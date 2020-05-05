package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Leetcode
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> interimList = new ArrayList<>();
        findCombination(candidates,  target, interimList, 0);
        return result;
    }

    public void findCombination(int[] c, int t, List<Integer>in, int index){
        if(t<0){
            return;
        }

        if(t==0) {
            List<Integer> x = new ArrayList<>(in);
            result.add(x);
        }

        for(int i=index; i<c.length; i++){
            in.add(c[i]);
            findCombination(c,t-c[i], in, i);
            in.remove(in.size()-1);
        }
    }

    public static void main(String arg[]) {
        int[] combination ={2, 3, 3, 6, 7};
        int target =7;
        CombinationSum c = new CombinationSum();
        c.combinationSum(combination, target).forEach(e ->{
            e.forEach( f-> System.out.println(f));
        });
    }

}
