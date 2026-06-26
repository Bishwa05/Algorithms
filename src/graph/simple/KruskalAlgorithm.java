package graph.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Kruskal’s algorithm is a famous greedy algorithm used to find the
 * Minimum Spanning Tree (MST) of a connected, weighted, and undirected graph
 *
 * 1. Sort all edges in the graph in ascending order of their weights.
 * 2. Pick the smallest edge. Check if adding it to the MST forms a cycle.
 * 3. If it does not form a cycle, include it in your MST. Otherwise, discard it.
 * 4. Repeat step 2 and 3 until there are exactly V - 1 edges in the MST (where V is the total number of vertices).
 *
 */
public class KruskalAlgorithm {
    // Class to represent a graph edge
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Comparator function used for sorting edges based on their weights
        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

    // Disjoint Set (Union-Find) Data Structure
    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Every node is its own parent initially
            }
        }

        // Find the root of node 'i' with Path Compression
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); // Memorizes the root
        }

        // Union of two sets by Rank
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI == rootJ) {
                return false; // They belong to the same set; adding an edge creates a cycle
            }

            // Attach smaller rank tree under root of high rank tree
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
            return true; // Successfully unioned without creating a cycle
        }
    }

    public static List<Edge> kruskalsMST(int vertices, List<Edge> edges) {
        List<Edge> mst = new ArrayList<>();

        // Step 1: Sort all edges in non-decreasing order of their weight
        Collections.sort(edges);

        // Create a Disjoint Set for all vertices
        DisjointSet ds = new DisjointSet(vertices);

        // Step 2 & 3: Iterate through sorted edges
        for (Edge edge : edges) {
            // If including this edge doesn't cause a cycle, add it to MST
            if (ds.union(edge.src, edge.dest)) {
                mst.add(edge);
            }

            // Optimization: An MST always has exactly V-1 edges
            if (mst.size() == vertices - 1) {
                break;
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List edgeList = List.of(new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4));
        List<Edge> mutableList = new ArrayList<>(edgeList);

        KruskalAlgorithm k = new KruskalAlgorithm();
        k.kruskalsMST(4, mutableList).forEach(e -> System.out.println(e.toString()));
    }
}
