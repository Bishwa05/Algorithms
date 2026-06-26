package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortKahn {
    public static List<Integer> kahnTopologicalSort(int numVertices, List<List<Integer>> adjacencyList) {
        List<Integer> topoOrder = new ArrayList<>();
        int[] inDegree = new int[numVertices];

        // Step 1: Calculate in-degrees for all vertices
        for (int u = 0; u < numVertices; u++) {
            for (int v : adjacencyList.get(u)) {
                inDegree[v]++;
            }
        }

        // Step 2: Push all vertices with an in-degree of 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Process nodes level by level
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            // Decrease the in-degree of all neighboring nodes
            for (int v : adjacencyList.get(u)) {
                inDegree[v]--;

                // If in-degree drops to 0, add it to the queue
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // Step 4: Cycle Detection Check
        // If the topological order size is less than total vertices, a cycle exists.
        if (topoOrder.size() != numVertices) {
            return new ArrayList<>(); // Return empty list to signal invalid DAG (Cycle detected)
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Define a Directed Acyclic Graph (DAG)
        // Edges: 5->2, 5->0, 4->0, 4->1, 2->3, 3->1
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> result = kahnTopologicalSort(vertices, adj);

        if (result.isEmpty()) {
            System.out.println("The graph contains a cycle! Topological sort is impossible.");
        } else {
            System.out.println("Topological Sort Order: " + result);
        }
    }
}
