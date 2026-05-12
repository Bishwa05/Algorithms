package topologicalsort;
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */

import java.util.*;

/**
 * Kind of Dependency Resolver
 */
public class CourseSchedule {

    // (Kahn's Algorithm)
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


    // Another approach
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseGraph = new HashMap<>();

        for (int [] pre : prerequisites) {
            if (courseGraph.containsKey(pre[1])) {
                courseGraph.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(pre[0]);
                courseGraph.put(pre[1], nextCourses);
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int cuurentCourse = 0; cuurentCourse < numCourses; cuurentCourse++){
            if (!courseSchedule(cuurentCourse, visited, courseGraph)) {
                return false;
            }
        }
        return true;
    }

    private boolean courseSchedule(int course, HashSet<Integer> visited, Map<Integer, List<Integer>> courseGraph) {
        if (visited.contains(course)) return false;// cycle detected

        if (courseGraph.get(course) == null) return true;

        visited.add(course);

        for (int pre : courseGraph.get(course)) {
            if(!courseSchedule(pre, visited, courseGraph)) return false;
        }

        visited.remove(course);
        courseGraph.put(course, null);
        return true;
    }


    public static void main(String args[]) {
        int numCourses = 2;
        // int[][] prerequisites = {{1,0}};
        int[][] prerequisites = {{0,1}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
