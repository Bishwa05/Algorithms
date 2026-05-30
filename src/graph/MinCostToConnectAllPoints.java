package graph;
/**
 *
 * Leetcode 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class UnionFind {
    public int[] group;
    public int[] rank;

    public UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for(int i = 0; i< size; i++){
            group[i] = i;
        }
    }

    public int find(int node) {
        if(group[node] != node){
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public boolean union(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);

        // node1 and node2 already belong to same group
        if(group1 == group2){
            return false;
        }

        if(rank[group1]> rank[group2]) {
            group[group2] = group1;
        } else if(rank[group1]< rank[group2]){
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] +=1;
        }
        return true;
    }

}

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        //Storing all edges of our complete graph.
        for(int currNext = 0; currNext<n; currNext++){
            for(int nextNext = currNext + 1; nextNext <n ; nextNext++){
                int weight = Math.abs(points[currNext][0] - points[nextNext][0])
                        + Math.abs(points[currNext][1] - points[nextNext][1]);

                int[] currEdge = {weight, currNext, nextNext};
                allEdges.add(currEdge);

            }
        }

        //Sort all edges in increasing order
        Collections.sort(allEdges, (a, b)-> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;

        for(int i =0; i<allEdges.size() && edgesUsed< n-1; i++){
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if(uf.union(node1, node2)) {
                mstCost +=weight;
                edgesUsed++;
            }
        }
        return mstCost;
    }


    /**
     * Approach 2
     */
    public int minCostConnectPoints2(int[][] points) {
        int n = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        boolean[] inMST = new boolean[n]; // Whether a point is already in MST

        // Start with 1st point
        pq.offer(new Point(0,0));

        int minCost = 0;
        int pointsConnected = 0;
        while (pointsConnected < n) {
            Point curr = pq.poll();
            if (inMST[curr.index]) {
                continue; // skip if the point is already seen in MST
            }

            inMST[curr.index] = true;
            minCost += curr.distance;
            pointsConnected++;

            // update the pq with the distances to the new point in the MST
            for (int i = 0; i < n; i++) {
                if (!inMST[i]) {
                    int distance = Math.abs(points[curr.index][0] - points[i][0]) +
                            Math.abs(points[curr.index][1] - points[i][1]);
                    pq.offer(new Point(i, distance));
                }
            }
        }
    return minCost;
    }

    class Point {
        int index, distance;
        Point(int i, int d) {
            index = i;
            distance = d;
        }
    }
}
