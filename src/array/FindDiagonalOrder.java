package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDiagonalOrder
{
    public int[] findDiagonalOrder(int[][] matrix) {
        // check empty matrices
        if(matrix == null || matrix.length ==0){
            return new int[0];
        }

        // Variables to track the size of the matrix
        int R = matrix.length;
        int C = matrix[0].length;

        int[] result = new int[R*C];
        int k=0;
        List<Integer> intermediate = new ArrayList<>();


        for(int d =0; d<R+C-1; d++){
            intermediate.clear();
            int r = d < R ? 0: d - C + 1;
            int c = d < R ? d : C - 1;

            while(r < R && c > -1) {
                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            if(d % 2 ==0){
                Collections.reverse(intermediate);
            }

            for(int i =0; i< intermediate.size(); i++){
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
