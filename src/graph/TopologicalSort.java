package graph;

import java.util.*;

/**
 *                  A           B
 *                    \     /   |
 *                      C       D
 *                     /       /
 *                     E      /
 *                  /   \    /
 *                H        F
 *                          \
 *                          G
 *
 *  1. Pick any vertex u, put it in visited set.
 *  2. if u->v, visit to v
 *      3. Then goto step 1 for vertex v until no more path found.
 *  4. else put u in the stack.
 *  5. Repeat the step 1 for all the unvisited nodes.
 *
 */
public class TopologicalSort<T> {


    public Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            topSortUtil(vertex,stack,visited);
        }
        return stack;
    }

    private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack,
                             Set<Vertex<T>> visited) {
        visited.add(vertex);
        for(Vertex<T> childVertex : vertex.getAdjacentVertexes()){
            if(visited.contains(childVertex)){
                continue;
            }
            topSortUtil(childVertex,stack,visited);
        }
        stack.offerFirst(vertex);
    }

    /**
     *
     *      Algorithm: Steps involved in finding the topological ordering of a DAG:
     * Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.
     *
     * Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
     *
     * Step-3: Remove a vertex from the queue (Dequeue operation) and then.
     *
     * Increment count of visited nodes by 1.
     * Decrease in-degree by 1 for all its neighboring nodes.
     * If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
     * Step 4: Repeat Step 3 until the queue is empty.
     *
     * Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.
     *
     * How to find in-degree of each node?
     * There are 2 ways to calculate in-degree of every vertex:
     *
     * Take an in-degree array which will keep track of
     * Traverse the array of edges and simply increase the counter of the destination node by 1.
     * for each node in Nodes
     *     indegree[node] = 0;
     * for each edge(src, dest) in Edges
     *     indegree[dest]++
     * Time Complexity: O(V+E)
     *
     * Traverse the list for every node and then increment the in-degree of all the nodes connected to it by 1.
     *     for each node in Nodes
     *         If (list[node].size()!=0) then
     *         for each dest in list
     *             indegree[dest]++;
     * Time Complexity: The outer for loop will be executed V number of times and the inner for loop will be executed E number of times, Thus overall time complexity is O(V+E).
     *
     * The overall time complexity of the algorithm is O(V+E)
     *
     *
     */

    public void topologicalSort(Graph G)
    {

//        int V =5;
//        int indegree[] = new int[V];
//
//        for (int i = 0; i < V; i++) {
//            ArrayList<Integer> temp
//                = (ArrayList<Integer>)adj[i];
//            for (int node : temp) {
//                indegree[node]++;
//            }
//        }
//
//
//        Queue<Integer> q
//            = new LinkedList<>();
//        for (int i = 0; i < V; i++) {
//            if (indegree[i] == 0)
//                q.add(i);
//        }
//
//
//        int cnt = 0;
//
//        Vector<Integer> topOrder = new Vector<Integer>();
//        while (!q.isEmpty()) {
//
//            int u = q.poll();
//            topOrder.add(u);
//
//            for (int node : adj[u]) {
//
//                if (--indegree[node] == 0)
//                    q.add(node);
//            }
//            cnt++;
//        }
//
//        // Check if there was a cycle
//        if (cnt != V) {
//            System.out.println(
//                "There exists a cycle in the graph");
//            return;
//        }

        // Print topological order
//        for (int i : topOrder) {
//            System.out.print(i + " ");
//        }
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        TopologicalSort<Integer> sort = new TopologicalSort<>();
        Deque<Vertex<Integer>> result = sort.topSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}
