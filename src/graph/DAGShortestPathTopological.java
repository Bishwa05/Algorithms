package graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DAGShortestPathTopological<T>
{
    public Map<Vertex<T>,Integer> shortestPath(Graph<T> graph,Vertex<T> startVertex){

        Map<Vertex<T>,Integer> distance = new HashMap<>();
        TopologicalSort<T> sort = new TopologicalSort<T>();
        Deque<Vertex<T>> deque = sort.topSort(graph);
        distance.put(startVertex, 0);
        while(!deque.isEmpty()){
            Vertex<T> vertex = deque.poll();
            for(Edge<T> edge : vertex.getEdges()){
                if(getDistance(edge.vertex2,distance) > getDistance(edge.vertex1,distance) + edge.weight){
                    distance.put(edge.vertex2, getDistance(edge.vertex1,distance) + edge.weight);
                }
            }
        }

        return distance;
    }

    private int getDistance( Vertex<T> vertex,Map<Vertex<T>,Integer> distance){
        return distance.containsKey(vertex) ? distance.get(vertex) : 1000;
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 2,4);
        graph.addEdge(2, 3,3);
        graph.addEdge(2, 4,2);
        graph.addEdge(1, 3,2);
        graph.addEdge(3, 5,1);
        graph.addEdge(4, 5,5);
        graph.addEdge(5, 6,2);
        graph.addEdge(4, 7,3);

        DAGShortestPathTopological<Integer> shortestPath = new DAGShortestPathTopological<Integer>();
        Map<Vertex<Integer>,Integer> distance = shortestPath.shortestPath(graph, graph.getAllVertex().iterator().next());
        System.out.print(distance);

    }
}
