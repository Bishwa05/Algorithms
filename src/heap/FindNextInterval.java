package heap;

import java.util.PriorityQueue;

/**
 *
 * Write a function to return an array containing indices of the next interval of each input interval. If there is no next interval of a given interval, return -1. It is given that none of the intervals have the same start point.
 *
 * Example 1:
 *
 * Input: Intervals [[2,3], [3,4], [5,6]]
 * Output: [1, 2, -1]
 * Explanation: The next interval of [2,3] is [3,4] having index ‘1’. Similarly, the next interval of [3,4] is [5,6] having index ‘2’. There is no next interval for [5,6] hence we have ‘-1’.
 *
 * Example 2:
 *
 * Input: Intervals [[3,4], [1,5], [4,6]]
 * Output: [2, -1, -1]
 * Explanation: The next interval of [3,4] is [4,6] which has index ‘2’. There is no next interval for [1,5] and [4,6].
 *
 */

class Interval {
  int start = 0;
  int end = 0;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
public class FindNextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        PriorityQueue<Integer> minHeapEnd = new PriorityQueue<>((i, j) -> intervals[i].end - intervals[j].end);
        PriorityQueue<Integer> minHeapStart = new PriorityQueue<>((i, j) -> intervals[i].start - intervals[j].start);

        int n = intervals.length;
        int[] result = new int[n];
        for (int i = 0; i< n; i++) {
            minHeapEnd.offer(i);
            minHeapStart.offer(i);
        }

        while (!minHeapEnd.isEmpty()) {
            int endIdx = minHeapEnd.poll();
            int endTime = intervals[endIdx].end;
            result[endIdx] = -1;

            while (!minHeapStart.isEmpty() &&
            intervals[minHeapStart.peek()].start < endTime) {
                minHeapStart.poll();
            }

            if (!minHeapStart.isEmpty()) {
                result[endIdx] = minHeapStart.peek();
            }
        }
        return result;
    }


    public int[] findNextInterval2(Interval[] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap =
                new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
        // heap for finding the max end
        PriorityQueue<Integer> maxEndHeap =
                new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            // let's find the next interval of the interval which has the highest 'end'
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                // find the the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty()
                        && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                // put the interval back as it could be the next interval of other intervals
                maxStartHeap.add(topStart);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        FindNextInterval sol = new FindNextInterval();
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4),
                new Interval(5, 6) };
        int[] result = sol.findNextInterval2(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5),
                new Interval(4, 6) };
        result = sol.findNextInterval2(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
