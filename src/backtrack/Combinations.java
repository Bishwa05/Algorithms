package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Combinations
{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(n, k, 1, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int n, int k, int pos, List<List<Integer>> res, List<Integer> temp){

        if(k == 0){
            List<Integer> temp1 = new ArrayList<>(temp);
            res.add(temp1);
            return;
        }

        for(int i =pos; i<=n; i++){
            temp.add(i);
            backtrack(n, k-1, i+1, res, temp);
            temp.remove(temp.size() -1);
        }

    }


    public static void main(String arg[]){
        Combinations c = new Combinations();
        c.combine(4, 2).forEach(
            e-> {
                System.out.println(e.get(0)+":"+e.get(1));
            }
        );
    }

}
