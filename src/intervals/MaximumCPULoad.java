package intervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 *
 * Example 1:
 *
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the jobs are running at the same time i.e., during the time interval (2,4).
 *
 */
public class MaximumCPULoad {

    class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }

    public int findMaxCPULoad(List<Job> jobs) {
        int maxCPULoad = 0;
        // TODO: Write your code here
        int currentCPULoad = 0;
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for (Job job : jobs) {
            // remove all the jobs that have ended
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end)
                currentCPULoad = currentCPULoad - minHeap.poll().cpuLoad;

            // add the current job to minHeap
            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(currentCPULoad, maxCPULoad);
        }
        return maxCPULoad;
    }
}
