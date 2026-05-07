package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
 *
 * Example 1:
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 *
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 *
 */
public class IntervalsIntersection {
    public List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<Interval>();
        // TODO: Write your code here

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) ||
                    (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                int start = Math.max(arr1[i].start, arr2[j].start);
                int end = Math.min(arr1[i].end, arr2[j].end);
                result.add(new Interval(start, end));
            }

            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
