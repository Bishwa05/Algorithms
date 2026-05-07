package intervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.
 * Example 2:
 *
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 */


class MinimumMeetingRooms {
    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

        public int findMinimumMeetingRooms(List<Meeting> meetings) {
            int minRooms = 0;
            // TODO: Write your code here

            if (meetings == null || meetings.size() == 0) return 0;

            Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

            PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));

            for (Meeting meeting : meetings) {
                // remove all meeting that have ended
                while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
                    minHeap.poll();
                // add the current meeting to minHeap
                minHeap.offer(meeting);
                // all active meetings are in minHeap, so we need rooms for all
                minRooms = Math.max(minRooms, minHeap.size());
            }
            return minRooms;
    }

}