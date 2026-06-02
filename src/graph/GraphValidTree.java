package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjList.get(node)) {
                if (visited.contains(neighbour)) continue;

                visited.add(neighbour);
                stack.push(neighbour);
            }
        }

        if (visited.size() == n) return true;

        return false;
    }
}
