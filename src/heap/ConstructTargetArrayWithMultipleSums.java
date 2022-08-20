package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/construct-target-array-with-multiple-sums/
 * Leetcode : 1354. Construct Target Array With Multiple Sums
 *
 */
public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int t: target) {
            pq.add(t);
            sum += t;
        }

        while (pq.peek() != 1) {
            int curr = pq.poll();
            if (sum - curr == 1) return true;

            int x = curr % (sum - curr);
            sum = sum - curr + x;

            if (x == 0 || x == curr) return false;
            else pq.add(x);
        }

        return true;
    }
}
