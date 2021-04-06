package topologicalsort;

import java.util.*;

/**
 *
 * 210. Course Schedule II
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 */
class Course {
    int course;
    boolean isVisited;
    boolean isDone;
    List<Course> dep;

    public Course(int num){
        this.course = num;
        this.isDone = false;
        this.isVisited = false;
        this.dep = new ArrayList<>();
    }

    void add(Course course){
        this.dep.add(course);
    }
}
public class CourseScheduleII
{
    Stack<Integer> result = new Stack<>();

    public int[] findOrder(int numCourses, int[][]prerequisites){
        Course[] courses = new Course[numCourses];

        //Create the courses
        for(int i=0; i<numCourses; i++){
            courses[i] = new Course(i);
        }

        //Add the dependencies
        for(int i =0; i<prerequisites.length; i++){
            courses[prerequisites[i][1]].add(courses[prerequisites[i][0]]);
        }

        for(int i =0; i<numCourses; i++){
            if(isCyclic(courses[i]))
                return new int[]{};
        }

        int[] resultArr = new int[numCourses];

        for(int i=0; i<numCourses; i++)
            resultArr[i] = result.pop();

        return resultArr;
    }

    boolean isCyclic(Course curr){
        if(curr.isDone) return false;
        if(curr.isVisited) return true;

        curr.isVisited = true;

        for(Course currDep : curr.dep){
            if(isCyclic(currDep)){
                return true;
            }
        }
        curr.isVisited = false;
        curr.isDone = true;
        result.push(curr.course);
        return false;
    }

    /**
     *
     */

    private boolean dfs(int u, List<Integer>[] adj, List<Integer> s, int[] visited){
        visited[u] = 1;
        for(int v : adj[u]){
            if(visited[v] == 1) return true;
            if(visited[v] == 0 && dfs(v, adj, s, visited)) return true;
        }
        visited[u] = 2;
        s.add(u);
        return false;
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; ++i)
            adj[i] = new LinkedList<>();
        for(int[] courses: prerequisites)
            adj[courses[1]].add(courses[0]);

        List<Integer> s = new LinkedList();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; ++i)
            if(visited[i] == 0 && dfs(i, adj, s, visited)) return new int[0];
        Collections.reverse(s);
        int[] result = s.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }


    public static void main(String args[]) {
        int numCourses = 4;
        // int[][] prerequisites = {{1,0}};
        int[][] prerequisites = {{0,1}, {2,0}, {3,1}, {3,2}};
        CourseScheduleII cs2 = new CourseScheduleII();

        System.out.println(cs2.findOrder2(numCourses, prerequisites));
    }
}
