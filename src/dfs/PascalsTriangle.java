package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 *
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> oneElement = new ArrayList<>();

        oneElement.add(1);
        res.add(oneElement);
        numRows -=1;
        if(numRows == 0) return res;
        dfs(numRows, res, oneElement);
        return res;
    }

    public void dfs(int n, List<List<Integer>> res, List<Integer> row) {
        int rowL = row.size();
        List<Integer> currList = new ArrayList<>();
        for(int i = 0; i < rowL; i++) {
            if(i == 0) {
                currList.add(row.get(i));
            } else {
                currList.add(row.get(i)+row.get(i-1));
            }
        }
        currList.add(row.get(rowL-1));
        res.add(currList);
        n -=1;
        if(n>0) {
            dfs(n, res, currList);
        }
    }

    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        List<List<Integer>> res = p.generate(5);
        res.forEach(e-> {
            e.forEach(y -> System.out.print(y));
            System.out.println();
        });
    }

}
