package array;

import java.util.*;

/**
 *
 * Leetcode 1288. Remove Covered Intervals
 *
 * Given a list of intervals, remove all intervals that are covered by another interval in the list. Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 *
 *
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int remaining = intervals.length;
        for(int i = 0; i< intervals.length; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            for(int j = 0; j< intervals.length; j++){
                int c = intervals[j][0];
                int d = intervals[j][1];

                if(i != j && c<=a && b<=d){
                    remaining -=1;
                    break;
                }


            }

        }
        return remaining;
    }

    public static void main(String arg[]) {

        //int[][] intervals = {{1,4},{3,6},{2,8}};

        //int[][] intervals = {{1,2},{1,4},{3,4}};

        //int[][] intervals ={{3,10},{4,10},{5,11}};

        //int[][] intervals = {{1,4},{2,3}};

        int[][] intervals = {{66672,75156},{59890,65654},{92950,95965},{9103,31953},{54869,69855},{33272,92693},{52631,65356},{43332,8972},{4218,5772},{20993,92876}};

        RemoveCoveredIntervals r  = new RemoveCoveredIntervals();
        System.out.println(r.removeCoveredIntervals(intervals));

    }
}
