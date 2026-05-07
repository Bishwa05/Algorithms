package intervals;

/**
 *
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 * <p>
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 *
 */
public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
