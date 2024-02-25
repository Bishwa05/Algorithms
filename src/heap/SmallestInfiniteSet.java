package heap;
/**
 *
 * https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 *
 * Implement the SmallestInfiniteSet class:
 *
 *     SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 *     int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 *     void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 *
 */

import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    PriorityQueue<Integer> smallestIntegers = new PriorityQueue<>();
    private int lowerInfiniteBound = 1;

    public SmallestInfiniteSet() {
        // smallestIntegers = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (smallestIntegers.isEmpty())
        {
            return lowerInfiniteBound++;
        }

        return smallestIntegers.poll();
    }

    public void addBack(int num) {
        if (num > 0 && num < lowerInfiniteBound && !smallestIntegers.contains(num))
        {
            smallestIntegers.offer(num);
        }
    }
}
