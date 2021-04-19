package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *     [[1, 2, 30],
 * //        [40, 5, 6],
 * //        [7, 8, 9]]
 * //
 * //    Absolute diff path 1->2->5>8>9
 *
 */
public class AbsoluteDifferencePathMatrix
{

    public String solve(int[][]mat, int k){
        List<Integer> res = new ArrayList<>();
        //res.add(mat[0][0]);
        StringBuilder sb = new StringBuilder();
        dfs(mat,0,0, k, res, 0);
        for(int i : res){
            sb.append(i);
        }
        return sb.toString();
    }

    public void dfs(int[][]mat, int i, int j, int k, List<Integer> list, int val){
        int m = mat.length;
        int n = mat[0].length;
        if(mat[i][j]==-1 ||  Math.abs(mat[i][j] -val) > k) return;
//        if(i == m-1 && j == n-1) {
//            return;
//        }

        System.out.println("i:"+i+":j:"+j+":mat:"+mat[i][j]+":val:"+val);

        if(list.isEmpty() || Math.abs(mat[i][j] -val) < k){
          list.add(mat[i][j]);
        }
        int val2 = mat[i][j];
        mat[i][j] = -1;

        if(i>0) dfs(mat, i-1, j, k, list, val2);
        if(i<m-1) dfs(mat, i+1, j, k, list,val2);
        if(j>0) dfs(mat, i, j-1, k, list,val2);
        if(j<n-1) dfs(mat, i, j+1, k, list,val2);
        //mat[i][j] = val;

        //list.remove(list.size() -1);

    }

    public static void main(String arg[]){
        AbsoluteDifferencePathMatrix a = new AbsoluteDifferencePathMatrix();
        int[][]mat = {{1,2,3},{50,4,90},{70,6,8}};
        System.out.println(a.solve(mat, 3));
    }

}
