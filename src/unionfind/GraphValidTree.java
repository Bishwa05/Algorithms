package unionfind;

/**
 * Leetcode 261:
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to check whether these edges
 * make up a valid tree.
 *
 * Example 1:
 * Input n = 5 and edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output : true
 *
 * Example 2:
 * Input n = 5, and edges = [[0,1], [1,2],[2,3], [1,3], [1,4]]
 * Output : false
 */
public class GraphValidTree
{

    public boolean validTree(int n, int[][] edges){
        if(edges.length != n){
            return false;
        }

        int []ids = new int[n];
        for(int i=0; i< n; i++){
            ids[i] = i;
        }

        //check cycle
        for(int[] edge : edges){
            int r1 = find(ids, edge[0]);
            int r2 = find(ids, edge[1]);

            if(r1 == r2){
                return false;
            }

            // add edge
            ids[r1] = r2;
        }
        return true;
    }

    public int find(int[] ids, int i){
       while(i!= ids[i]){
           ids[i] = ids[ids[i]];
           i = ids[i];
       }
        return i;
    }

    public static void main(String arg[]){
        GraphValidTree g = new GraphValidTree();
        int [][] edges = {{0,1}, {1,2},{2,3}, {1,3}, {1,4}};
        System.out.println(g.validTree(5, edges));
    }
}
