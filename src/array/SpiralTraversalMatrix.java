package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalMatrix
{
    public void printSpiralOrderMatrix(int[][] mat){
        int startRow =0, startColumn =0;
        int endRow = mat.length-1;
        int endColumn = mat[0].length-1;
        List<Integer> result = new ArrayList<>();

        while(startRow<=endRow && startColumn<=endColumn){
            for(int i =startColumn; i<=endColumn; i++){
                result.add(mat[startRow][i]);
            }

            for(int i =startRow+1; i<=endRow; i++){
                result.add(mat[i][endColumn]);
            }
            for(int i =endColumn-1; i>=startColumn; i--){
                result.add(mat[endRow][i]);
            }
            for(int i =endRow-1; i>startRow; i--){
                result.add(mat[i][startColumn]);
            }

            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }

        for(int i : result){
            System.out.println(i);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;int bottom=matrix.length-1;
        int left=0;int right=matrix[0].length-1;
        List<Integer>result=new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;

            }
        }
        return result;
    }

    public static void main(String arg[]){
        // int mat[][] = {{1,2,3,4}, {5,6,7,8},
        //                {9,10,11,12}, {13, 14, 15, 16}};

        int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralTraversalMatrix s = new SpiralTraversalMatrix();
        s.printSpiralOrderMatrix(mat);
    }
}
