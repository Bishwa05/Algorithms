package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

    class EmployeeInterval {
        Interval interval; // interval representing employee's working hours
        int employeeIndex; // index of the list containing working hours of this employee
        int intervalIndex; // index of the interval in the employee list

        public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }
    };

    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // PriorityQueue to store one interval from each employee
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start));

        // insert the first interval of each employee to the queue
        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free
            // interval
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else { // overlapping intervals, update the previousInterval if needed
                if (previousInterval.end < queueTop.interval.end)
                    previousInterval = queueTop.interval;
            }

            // if there are more intervals available for the same employee, add their next
            // interval
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(
                        employeeSchedule.get(queueTop.intervalIndex + 1), queueTop.employeeIndex,
                        queueTop.intervalIndex + 1));
            }
        }

        return result;
    }
}
