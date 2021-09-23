package disjointset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode 399. Evaluate Division
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 */

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < values.length; i++) {
            List<String> pair = equations.get(i);
            if(!map.containsKey(pair.get(0))) {
                map.put(pair.get(0), index++);
            }

            if(!map.containsKey(pair.get(1))) {
                map.put(pair.get(1), index++);
            }
            //map
        }

        int n = map.size();
        Double[][] graph = new Double[n][n];
        for(int i = 0; i < values.length; i++) {
            List<String> pair = equations.get(i);
            int a = map.get(pair.get(0)), b = map.get(pair.get(1));
            graph[a][b] = values[i];
            graph[b][a] = values[i] == 0 ? 0 : 1.0 / values[i];
        }

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            graph[i][i] = 1.0;
            dfs(i, i, 1.0, visited, graph);
        }

        double[] result = new double[queries.size()];
        for(int i = 0; i < result.length; i++) {
            List<String> q = queries.get(i);
            String from = q.get(0), to = q.get(1);
            if(map.containsKey(from) && map.containsKey(to) && graph[map.get(from)][map.get(to)] != null) {
                result[i] = graph[map.get(from)][map.get(to)];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    private void dfs(int start, int cur, double curValue, boolean[] visited, Double[][] graph) {
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            if(graph[cur][i] != null) {
                graph[start][i] = curValue * graph[cur][i];
                visited[i] = true;
                dfs(start, i, curValue * graph[cur][i], visited, graph);
            }
        }
    }

    public static void main(String args[]) {

        String [] a = {"a", "b"};
        String [] b = {"b", "c"};
        List eq = new ArrayList();
        eq.add(Arrays.asList(a));
        eq.add(Arrays.asList(b));


        String [] c = {"a", "c"};
        String [] d = {"b", "a"};
        String [] e = {"a", "e"};
        String [] f = {"b", "a"};
        String [] g = {"x", "x"};


        List q = new ArrayList();
        q.add(Arrays.asList(c));
        q.add(Arrays.asList(d));
        q.add(Arrays.asList(e));
        q.add(Arrays.asList(f));
        q.add(Arrays.asList(g));



        double[] val ={2.0, 3.0};
        EvaluateDivision ev = new  EvaluateDivision();
        System.out.println(ev.calcEquation(eq, val, q));
    }
}
