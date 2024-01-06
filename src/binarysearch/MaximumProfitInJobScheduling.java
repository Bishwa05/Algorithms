package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int numJobs = profit.length; // Number of jobs
        Job[] jobs = new Job[numJobs];

        for (int i = 0; i < numJobs; i++) {
            jobs[i] = new Job(endTime[i], startTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        int[] dp = new int[numJobs + 1];

        for (int i = 0; i< numJobs; i++) {
            int endTimeValue = jobs[i].endTime;
            int startTimeValue = jobs[i].startTime;
            int profitValue = jobs[i].profit;

            int latestNonConflictJobIndex = upperBound(jobs, i, startTimeValue);
            dp[i + 1] = Math.max(dp[i], dp[latestNonConflictJobIndex] + profitValue);
        }
        return dp[numJobs];
    }

    private int upperBound(Job[] jobs, int endIndex, int targetTime) {
        int low = 0;
        int high = endIndex;

        while(low < high) {
            int mid = (low + high) / 2;
            if (jobs[mid].endTime <= targetTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int endTime, int startTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[] startTime = new int[] {1,2,3,4,6};
        int[] endTime = new int[] {3,5,10,6,9};
        int[] profit = new int[] {20,20,100,70,60};

        MaximumProfitInJobScheduling mjs = new MaximumProfitInJobScheduling();

        System.out.println(mjs.jobScheduling(startTime, endTime, profit));

    }
}
