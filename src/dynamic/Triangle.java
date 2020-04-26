package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class Triangle {

    /**
     * In this recursive solution we are going through each path in the triangle from top to bottom
     * and calculating the cost.
     *
     * The base case is in last row the min path is the value itself.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return findMinPath(triangle, 0, 0).intValue();

    }

    public Integer findMinPath(List<List<Integer>> triangle, int rowNum, int index) {
        List<Integer> row = triangle.get(rowNum);

        // base case, we are at the last row
        if (rowNum == triangle.size() - 1) {
            return row.get(index);
        }

        int currValue = row.get(index);
        int maxSumLeft = findMinPath(triangle, rowNum+1, index);
        int maxSumRight = findMinPath(triangle, rowNum+1, index+1);

        return currValue + Math.min(maxSumLeft, maxSumRight);

    }

    //memoization



    public static void main(String arg[]){
        List out = new ArrayList();

        List in1 = Arrays.asList(2);
        List in2 = Arrays.asList(3,4);
        List in3 = Arrays.asList(6,5,7);
        List in4 = Arrays.asList(4,1,8,3);

        out.add(in1); out.add(in2); out.add(in3); out.add(in4);
        Triangle t =  new Triangle();
        System.out.println(t.minimumTotal(out));
    }
}
