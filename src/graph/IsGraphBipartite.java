package graph;

import java.util.Arrays;

public class IsGraphBipartite
{
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;


        int [] colorArr = new int[N];
        Arrays.fill(colorArr, -1);

        for(int i =0; i<N; i++){
            if(colorArr[i] == -1 && !paint(colorArr, i, graph, 0)){
                return false;
            }
        }
        return true;

    }

    private boolean paint(int[] colorArr, int id, int[][] graph, int color){

        colorArr[id] = color;
        for(int nextId : graph[id]){
            if(colorArr[nextId]== color) return false;
            if(colorArr[nextId] == -1 &&!paint(colorArr, nextId, graph, 1-color)){
                return false;
            }
        }
        return true;
    }
}
