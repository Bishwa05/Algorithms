package unionfind;

/**
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 *
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 *
 * [[3,4],[1,2],[2,4],[3,5],[2,5]]
 *
 *
 */
public class RedundantConnection
{
    public int[] findRedundantConnection(int[][] edges){

//        boolean[] visited = new boolean[edges.length];
//
//        for(int[] edge : edges){
//            if(visited[edge[0]-1] && visited[edge[1]-1]){
//                return edge;
//            }
//
//            visited[edge[0]-1]= true;
//            visited[edge[1]-1]= true;
//        }
//        int[] arr = {-1,-1};
//        return arr;

        // Initialize the parent array where parent[i] represents the parent of node i
        int[] parent = new int[edges.length+1];

        for(int i =1; i< edges.length; i++){
            parent[i] = i; // Initially each node is its own parent.
        }

        // Iterate through the edge to find the redundant one
        for(int[] edge : edges){ // finding the roots of node1 and node2
            int root1 = find(parent, edge[0]-1);
            int root2 = find(parent, edge[1]-1);
            // If the roots are same, cycle is detected, return the current edge
            if(root1 ==root2){
                return edge;
            }
            // Union the sets by making root1 the parent of root2
            parent[root1] = root2;

        }
        // If no cycle found.
        int[] arr1 = {-1,-1};
        return arr1;
    }

    private int find(int[] parent, int node) {
        if(parent[node] == node) return node;
        else return find(parent, parent[node]);
    }

    // Iterative approach of find
    private int findItr(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }


    public static void main(String arg[]){
        int [][]nums = {{3,4},{1,2},{2,4},{3,5},{2,5}};

        RedundantConnection r = new RedundantConnection();

        for (int i : r.findRedundantConnection(nums)) {
            System.out.println(i);
        }
    }
}
