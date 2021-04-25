package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * Articulation Points (or Cut Vertices) in a Graph
 *
 *
 *
 * 1) u is root of DFS tree and it has at least two children.
 * 2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
 *
 */

class Graph1{
    private int V;

    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL= -1;

    Graph1(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i =0; i<V; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }


    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    public void apUtil(int u, boolean visited[], int disc[],
                       int low[], int parent[], boolean ap[]){
        // Count of children in DFS tree
        int children =0;

        //mark the current node as visited
        visited[u] = true;

        //
        disc[u] = low[u] = ++time;

        Iterator<Integer> i = adj[u].iterator();

        while(i.hasNext()){
            int v = i.next();

            if(!visited[v]){
                children++;
                parent[v] = u;
                apUtil(v, visited, disc, low, parent, ap);

                low[u] = Math.min(low[u], low[v]);

                // u is root of DFS tree and has 2 or more children
                if(parent[u] == NIL && children >1)
                    ap[u] = true;

                // if u is not root and low value of one of its child is more than
                // discovery value of u.
                if(parent[u] != NIL && low[v]>=disc[u])
                    ap[u] = true;

            }
            else if(v != parent[u])
                low[u] = Math.min(low[u], disc[v]);

        }
    }

    public void AP(){
        boolean []visited = new boolean[V];
        int [] disc = new int[V];
        int []low = new int[V];
        int []parent = new int[V];
        boolean []ap = new boolean[V];

        for(int i =0; i<V; i++){
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        for(int i =0; i<V; i++){
            if(visited[i] != true){
                apUtil(i, visited, disc, low, parent, ap);
            }
        }

        for(int i =0; i<V; i++){
            if(ap[i] == true){
                System.out.println(i);
            }
        }
    }
}
public class ArticulationPoint
{
    public static void main(String arg[]){

        Graph1 g1 = new Graph1(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.AP();
        System.out.println();

        Graph1 g2 = new Graph1(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.AP();
        System.out.println();
    }

}
