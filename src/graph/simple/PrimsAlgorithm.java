package graph.simple;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    // Class to represent a graph neighbor node and edge weight
    static class Pair implements Comparable<Pair> {
        int vertex, weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // Min-Heap sorting based on edge weight
        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    public static int primsMST(int vertices, List<List<Pair>> adj) {
        // Track total weight of the MST
        int mstCost = 0;

        // Tracks vertices that are securely locked into our MST
        boolean[] inMST = new boolean[vertices];

        // Min-Priority Queue to automatically hand us the cheapest available edge
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start at Vertex 0 with a weight cost of 0
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;
            int w = curr.weight;

            // If the vertex is already part of the MST, discard this edge choice
            if (inMST[u]) continue;

            // Include this vertex and accumulate the edge cost
            inMST[u] = true;
            mstCost += w;

            // Explore all neighbors of the newly added vertex u
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If neighbor is not yet in MST, push it to the priority queue
                if (!inMST[v]) {
                    pq.add(new Pair(v, weight));
                }
            }
        }

        return mstCost;
    }
}
