package graph;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // Create a graph represents as adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
        }

        // Use priority queue to select node with the minimum distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Start from node k with distance of 0.

        // Initialize distances array with infinity
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0; // Distance to itself is 0.

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // if we already found a shorter path before, continue
            if (currentDistance > distances[currentNode]) continue;

            // Update the distance of neighboring node
            if(graph.containsKey(currentNode)) {
                for (int[] neighbor : graph.get(currentNode)) {
                    int nextNode = neighbor[0];
                    int nextDistance = currentDistance + neighbor[1];
                    if (nextDistance < distances[nextNode]) {
                        distances[nextNode] = nextDistance;
                        pq.offer(new int[] {nextNode, nextDistance});
                    }
                }
            }
        }

        // Find the max distance from source node to all other nodes
        int maxDist = Arrays.stream(distances).skip(1).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;

    }
}
