package graph;

import java.util.*;

/**
 *
 * Given a directed graph, find all strongly connected components in this graph.
 * We are going to use Kosaraju's algorithm to find strongly connected component.
 *
 * Algorithm
 * Create a order of vertices by finish time in decreasing order.
 * Reverse the graph
 * Do a DFS on reverse graph by finish time of vertex and created strongly connected
 * components.
 *
 */
public class StronglyConnectedComponent
{



//    public List<Set<Vertex<Integer>>> scc(Graph<Integer> graph){
//
//        //
//        Deque<Vertex<Integer>> stack = new ArrayDeque<>();
//
//        Set<Vertex<Integer>> visited = new HashSet<>();
//
//        for(Vertex<Integer> vertex : graph.getAllVertex()){
//            if(visited.contains(vertex)){
//                continue;
//            }
//            DFSUtil(vertex, visited, stack);
//        }
//    }
}
