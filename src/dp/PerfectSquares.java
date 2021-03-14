package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares
{

    public static int bfs (int n)
    {
        //first get the perfect squares under the given number
        List<Integer> perfectSquaresUnderNs = perfectSquaresUnderN(n);

        int step = 1;
        //check the number it self is in the perfect square then return 1
        if (perfectSquaresUnderNs.contains(n)) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        //add the first number
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //now at the current level of nodes perform following while loop
            while (size > 0) {
                int currentValue = queue.poll();//get the first number
                //iterate throught the perfect square array. and do currentNo-one of the perfect square if result leads to zero then just return the steps.
                for (Integer i : perfectSquaresUnderNs) {
                    int result = currentValue - i;
                    if (result == 0) {
                        return step;
                    }
                    if (result > 0) {
                        queue.offer(result);
                    }
                }
                size--;
            }
            step++;
        }
        return 0;
    }

    static List perfectSquaresUnderN (int n)
    {
        List arrayList = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (i == Math.sqrt(i * i)) {
                arrayList.add(i * i);
            }
        }
        return arrayList;
    }

    public static int numSquare (int n)
    {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= n; j++) {
                int x = j * j;
                if (x <= i) {
                    dp[i] = Math.min(dp[i - x] + 1, dp[i]);
                }
            }

        }
        return dp[n];
    }

    public static void main (String arg[])
    {
        int n = 21;
        System.out.println(numSquare(n));
        System.out.println(bfs(n));

    }
}
