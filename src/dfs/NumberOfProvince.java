package dfs;

/**
 * https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 */
public class NumberOfProvince {

    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for(int i = 0; i< isConnected.length; i++) {
            if(isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i< n; i++) {
            if(!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }
        return numberOfComponents;
    }

}
