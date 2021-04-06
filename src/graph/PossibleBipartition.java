package graph;

import java.util.*;

/**
 * Leetcode 886. Possible Bipartition
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 */
public class PossibleBipartition
{
    public boolean possibleBipartition(int N, int[][] dislikes){
        List<Integer> []dislikesArr = new List[N+1];

        for(int i =0; i< dislikes.length; i++){
            dislikesArr[i] = new ArrayList<>();
        }

        for(int i =0; i< dislikes.length; i++){
            dislikesArr[dislikes[i][0]].add(dislikes[i][1]);
            dislikesArr[dislikes[i][1]].add(dislikes[i][0]);
        }

        int [] group = new int[N+1];
        Arrays.fill(group, -1);

        for(int i =1; i<=N; i++){

            if(group[i] == -1 && !paint(group, i, dislikesArr, 0)){
                return false;
            }
        }
        return true;
    }

    //dfs
    private boolean paint(int[] group, int index, List<Integer>[] dislikesArr, int color){
        group[index] = color;

        for(int i =0; i< dislikesArr[index].size(); i++){
            int nextIndex = dislikesArr[index].get(i);
            if(group[nextIndex] == color) return false;

            if(group[nextIndex]== -1 && !paint(group , nextIndex, dislikesArr, 1-color)){
                return false;
            }

        }
        return true;
    }


    //bfs
    private boolean paintBfs(int[] group, int index, List<Integer>[] dislikesArr, int color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);

        while(!q.isEmpty()){
            int id = q.poll();

            group[id] = color;

            for(int i =0; i< dislikesArr[index].size(); i++){
                int nextIndex = dislikesArr[index].get(i);

                if(group[nextIndex] == color) return false;

                if(group[nextIndex] == -1){
                    q.offer(nextIndex);
                }
            }
        }
        return true;

    }
}
