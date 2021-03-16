package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens
{
   List<List<String>> res = new ArrayList<>();
   boolean[] cols, diagonal, reverse;
   int size;
   char[][] arr;


   public List<List<String>> solveNQueens(int n){
       size = n;
       arr = new char[n][n];
       for(char[]a : arr){
           Arrays.fill(a, '.');
       }
       cols = new boolean[n];
       diagonal = new boolean[2 *n -1];
       reverse = new boolean[2* n -1];
       recur(0);
       return res;
   }

    private void recur(int r){
       if(r == size){
           List<String> list = new ArrayList<>();
           for(char[] array : arr){
               list.add(new String(array));
           }
           res.add(list);
           return;
       }

        for(int c=0; c<size; c++){
            if(!cols[c] && !diagonal[r+c] && !reverse[r-c +size -1]){
                cols[c] = diagonal[r+c] = reverse[r-c+size-1] = true;
                arr[r][c] ='Q';
                recur(r+1);
                arr[r][c] ='.';
                cols[c] = diagonal[r+c] = reverse[r-c+size-1] = false;
            }
        }
    }

}
