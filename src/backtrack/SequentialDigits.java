package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Leetcode 1291. Sequential Digits
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 */
public class SequentialDigits
{
    public List<Integer> sequentialDigits(int low, int high)
    {
        List<Integer> result = new ArrayList();

        for (int i = 1; i < 10; i++) {
            int next = 0;

            for (int j = i; j < 10; j++) {
                next = next * 10 + j;

                if (next >= low && next <= high) {
                    result.add(next);
                }
                else if (next > high) {
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }


    public List<Integer> sequentialDigitsBacktrack(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            dfs(i, low, high, list);
        }
        Collections.sort(list);
        return list;
    }

    public void dfs(int curr, int low, int high, List<Integer> list){
        if(curr>=low && curr<=high){
            list.add(curr);
        }

        if(curr>high){
            return;
        }

        int d = curr%10;
        if(d!=9){
            dfs(curr*10+(d+1), low, high, list);
        }
    }
}
