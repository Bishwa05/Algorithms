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

        int arr[] = new int[edges.length];

        for(int i =0; i< edges.length; i++){
            arr[i] = i;
        }

        for(int[] edge : edges){
            int u = find(arr, edge[0]-1);
            int v = find(arr, edge[1]-1);

            if(u ==v){
                return edge;
            }

            arr[u] = v;

        }
        int[] arr1 = {-1,-1};
        return arr1;
    }

    private int find(int[] arr, int i){
        if(arr[i] == i) return i;
        else return find(arr, arr[i]);
    }


    public static void main(String arg[]){
        int [][]nums = {{3,4},{1,2},{2,4},{3,5},{2,5}};

        RedundantConnection r = new RedundantConnection();

        for (int i : r.findRedundantConnection(nums)) {
            System.out.println(i);
        }
    }
}
