package unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Leetcode 547. Number of Provinces
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 */
public class NumberOfProvinces
{
    public int findCircleNum(int[][] isConnected)
    {
        int count =0;
        boolean []visited = new boolean[isConnected.length];

        for(int i=0; i<isConnected.length; i++){
            if(visited[i] == false){
                dfs(isConnected, i, visited);
                count++;
            }
        }
    return count;
    }
    public void dfs(int[][] inp, int city, boolean[] visited){
        if(visited[city]== true) return;
        visited[city] = true;

        int[] connect = inp[city];

        for(int i=0; i<inp.length; i++){
            if(i==city){
                continue;
            }
            if(connect[i]==1){
                dfs(inp, i, visited);
            }
        }
    }

    public static void main(String arg[]){
        NumberOfProvinces n = new NumberOfProvinces();

        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(n.findCircleNumUnionFind(isConnected));

    }

    public int findCircleNumUnionFind(int[][] isConnected)
    {
        int n = isConnected.length;
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = i;
        }

       for(int i=0; i<n; i++){
           for(int j =0; j<isConnected[i].length; j++){
               if(isConnected[i][j]!=1) continue;

               int u = find(arr, i);
               int v = find(arr, j);

               if(u != v) arr[v] = u;
           }
       }

        // This makes me stuck.
        Set<Integer> set = new HashSet<>();
       for(int i  :  arr){
           set.add(find(arr,i));
       }
        return set.size();

    }

    private int find(int []arr, int x){
        if(arr[x] ==x) return x;
        return find(arr, arr[x]);
    }

}
