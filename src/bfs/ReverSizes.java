package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  1 represents rvier and 0 represents land,
 *  find the length of rivers.
 *
 */
public class ReverSizes
{
    public List riverSizes(int[][] mat){

        if(mat == null || mat.length ==0 ||
        mat[0].length ==0) return null;

        List<Integer> res = new ArrayList<>();

        int m = mat.length;
        int n = mat[0].length;
        Queue<String> q = new LinkedList<>();

        for(int i =0; i<m ; i++){
            for(int j =0; j< n; j++){
                if(mat[i][j] == 1){
                    q.offer(i+"-"+j);
                    int arr[] = {0};
                    bfs(q, mat, arr);
                    res.add(arr[0]);
                }
            }
        }
        return res;
    }

    public void bfs(Queue<String> q, int[][] mat, int [] arr){

        int m = mat.length;
        int n = mat[0].length;
        while(!q.isEmpty()){
            String s = q.poll();
            int i = Integer.parseInt(s.split("-")[0]);
            int j = Integer.parseInt(s.split("-")[1]);
            mat[i][j] = 0;
            arr[0]++;

            if(i+1<m && mat[i+1][j] ==1) q.offer((i+1) +"-"+j);
            if(i-1>=0 && mat[i-1][j] ==1) q.offer((i-1)+"-"+j);
            if(j+1<n && mat[i][j+1] ==1) q.offer(i +"-"+(j+1));
            if(j-1>=0 && mat[i][j-1] ==1) q.offer(i+"-"+ (j-1));
        }
    }

    public static void main(String arg[]){
        ReverSizes r = new ReverSizes();
        int mat[][] = {{1,0,0,1,0},
                       {1,0,1,0,0},
                       {0,0,1,0,1},
                       {1,0,1,0,1},
                       {1,0,1,1,0}};
        r.riverSizes(mat).forEach((e) ->
            System.out.println(e));

    }
}
