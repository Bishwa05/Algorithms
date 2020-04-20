package topologicalsort;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int [][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int [] inDegree = new int[numCourses];

        // Indegree calculation
        for(int[] pr: prerequisites){
            List<Integer> l = adj.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]);
            inDegree[pr[0]]++;
            adj.put(pr[1],l);
        }

        //Add all the indegree of 0 to queue.
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] ==0) q.add(i);

        }

        int count =0;

        //Now BFS, breaking the connections in graph.
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(inDegree[curr] ==0) count++;
            if(!adj.containsKey(curr)) continue;

            for(int neighbour : adj.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] ==0) q.add(neighbour);
            }
        }

        return count == numCourses;

    }

    public static void main(String args[]) {
        int numCourses = 2;
        // int[][] prerequisites = {{1,0}};
        int[][] prerequisites = {{0,1}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
