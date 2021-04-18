package graph;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph
{
    public int findCenter(int[][] edges)
    {
        // int N = edges.length;
        // int[][] mat = new int[N+1][N+1];
        Map<Integer, Integer> nodeCount = new HashMap<>();
        for (int[] edge : edges) {
            nodeCount.put(edge[0], nodeCount.getOrDefault(edge[0], 0) + 1);
            nodeCount.put(edge[1], nodeCount.getOrDefault(edge[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : nodeCount.entrySet()) {
           // System.out.println(e.getValue());
            if (e.getValue() == edges.length)
                return e.getKey();
        }
        return -1;
    }


    public int findCenterOptimized(int[][] e) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int x=0;
        for(int i=0;i<e.length;i++){
            x=hm.getOrDefault(e[i][0],0)+1;
            hm.put(e[i][0],x);
            if(x>1){
                return e[i][0];
            }
            x=hm.getOrDefault(e[i][1],0)+1;
            hm.put(e[i][1],hm.getOrDefault(e[i][1],0)+1);
            if(x>1){
                return e[i][1];
            }
        }


        return x;
    }
}
