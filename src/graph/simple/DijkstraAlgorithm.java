package graph.simple;

import java.util.*;

public class DijkstraAlgorithm {
    // Class to represent a directed/undirected edge connection
    static class Edge {
        int targetNode;
        int weight;

        public Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }

    // Class to track node evaluation inside the Priority Queue
    static class PQNode {
        int nodeID;
        int distance;

        public PQNode(int nodeID, int distance) {
            this.nodeID = nodeID;
            this.distance = distance;
        }
    }

    public static int[] computeShortestPaths(int totalVertices, List<List<Edge>> graph, int source) {
        // Step 1: Initialize distances array with maximum possible values
        int[] distances = new int[totalVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Base case: Distance to the source vertex itself is always 0
        distances[source] = 0;

        // Step 2: Initialize Min-Heap Priority Queue sorted by distance
        PriorityQueue<PQNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        minHeap.add(new PQNode(source, 0));

        // Step 3: Core optimization loop
        while (!minHeap.isEmpty()) {
            PQNode current = minHeap.poll();
            int u = current.nodeID;

            // Stale check: skip processing if we found a shorter path to u already
            if (current.distance > distances[u]) {
                continue;
            }

            // Step 4: Relax neighboring edges
            for (Edge edge : graph.get(u)) {
                int v = edge.targetNode;
                int weight = edge.weight;

                // Check if a shorter path to neighbor 'v' exists via current node 'u'
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    minHeap.add(new PQNode(v, distances[v]));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Define graph topology: edge definitions
        graph.get(0).add(new Edge(1, 9));
        graph.get(0).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(0).add(new Edge(1, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 4));

        int sourceNode = 0;
        int[] results = computeShortestPaths(vertices, graph, sourceNode);

        System.out.println("Shortest distances from source node " + sourceNode + ":");
        for (int i = 0; i < results.length; i++) {
            String distStr = (results[i] == Integer.MAX_VALUE) ? "INF" : String.valueOf(results[i]);
            System.out.println("To Node " + i + " -> " + distStr);
        }
    }

}
