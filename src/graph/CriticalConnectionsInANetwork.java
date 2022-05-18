package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * Leetcode : 1192. Critical Connections in a Network
 *
 */
public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i<n; i++)  {
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> con : connections) {
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        HashSet<List<Integer>> connectionSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionSet);
        return new ArrayList<>(connectionSet);
    }


    private int dfs(List<Integer>[] graph, int node, int depth, int[] rank, HashSet<List<Integer>> connectionSet) {
        if(rank[node] >=0) {
            return rank[node];
        }

        rank[node] = depth;
        int minDepthFound = depth;
        for(Integer neighbor : graph[node]) {
            if(rank[neighbor] == depth -1){
                continue; // ignore parent
            }
            int minDepth = dfs(graph, neighbor, depth+1, rank, connectionSet);

            minDepthFound = Math.min(minDepthFound, minDepth);
            if(minDepth<=depth) {
                // to avoid the sorting just try remove both combination of (x, y) and (y, x)
                connectionSet.remove(Arrays.asList(node, neighbor));
                connectionSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }
}
