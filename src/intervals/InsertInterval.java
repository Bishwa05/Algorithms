package intervals;
/**
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * Example 2:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        // TODO: Write your code here
        if (intervals == null || intervals.isEmpty()) return Arrays.asList(newInterval);
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
            mergedIntervals.add(intervals.get(i++));
        }

        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(newInterval);

        // add all remaining
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }
        return mergedIntervals;
    }
}

