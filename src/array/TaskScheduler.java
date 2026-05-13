package array;

import java.util.*;

/**
 * 621. Task Scheduler
 */
public class TaskScheduler {
    public int leastInterval(char[] t,int n) {
        if(n>= t.length) return t.length;

        if(t.length%n ==0) return t.length+ t.length/n-1;
        else return t.length + t.length/n;
    }


    // Another better approach

    public int leastInterval2(char[] tasks, int n) {
        // 1. Count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) +1);
        }

        // 2. Build max heap based on frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        maxHeap.addAll(freqMap.values());

        // 3. process tasks
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for (int freq : temp) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }
            // 4. update time
            time += !maxHeap.isEmpty() ? temp.size() : n +1;
        }
        return time;
    }



    public static void main(String arg[]) {
        char chars[] = {'A','A','A','B','B','B','C'};
        int n = 10;
        TaskScheduler t  = new TaskScheduler();
        System.out.println(t.leastInterval(chars, n));

    }


}
