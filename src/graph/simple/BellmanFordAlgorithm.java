package graph.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    // Class to represent a directed edge in the graph
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int[] computeShortestPaths(int totalVertices, List<Edge> edges, int source) throws Exception {
        // Step 1: Initialize distances array with maximum possible values
        int[] distances = new int[totalVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Base case: Distance to the source vertex itself is always 0
        distances[source] = 0;

        // Step 2: Relax all edges (V - 1) times
        for (int i = 1; i <= totalVertices - 1; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;

                // Relax the edge if the source node has been reached and a shorter path is found
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    updated = true;
                }
            }
            // Optimization: If no distances change during an iteration, stop early
            if (!updated) {
                break;
            }
        }

        // Step 3: Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;

            if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                throw new Exception("Graph contains a negative weight cycle! Shortest paths cannot be accurately computed.");
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<Edge> edges = new ArrayList<>();

        // Define graph layout (includes a negative edge weight)
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, -4)); // Negative edge weight
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 3, 9));
        edges.add(new Edge(2, 4, -3)); // Negative edge weight
        edges.add(new Edge(3, 1, 7));
        edges.add(new Edge(4, 3, 2));

        int sourceNode = 0;

        try {
            int[] results = computeShortestPaths(vertices, edges, sourceNode);
            System.out.println("Shortest distances from source node " + sourceNode + ":");
            for (int i = 0; i < results.length; i++) {
                String distStr = (results[i] == Integer.MAX_VALUE) ? "INF" : String.valueOf(results[i]);
                System.out.println("To Node " + i + " -> " + distStr);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
