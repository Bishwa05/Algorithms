package array;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 *
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 *
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals
{
    public static List<Interval> merge(List<Interval> intervals){
        List<Interval> mergedIntervals = new LinkedList<>();

        if(intervals.size() <2) return intervals;

        Collections.sort(intervals, (a, b)->
            Integer.compare(a.start, b.start));

        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalItr.hasNext()){
            interval = intervalItr.next();
            if(interval.start<= end){
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        //add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

}
