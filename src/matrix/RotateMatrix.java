package matrix;

/**
 * Rotate a matrix clockwise by 90 degree
 */
public class RotateMatrix {

    public static int[][] rotateMatrixRec(int[][] mat, int rowStart, int rowEnd, int colStart, int colEnd){

        int rightTopCornor =  mat[rowStart][colEnd-1];
        int rightBottomCornor =  mat[rowEnd-1][colEnd-1];
        int leftBottomCornor =  mat[rowEnd-1][colStart];


        if(rowEnd-rowStart==2 || rowEnd-rowStart==3) {
            mat[rowStart][colEnd-1] = mat[rowStart][colStart];
            mat[rowEnd-1][colEnd-1] = rightTopCornor;
            mat[rowEnd-1][colStart] = rightBottomCornor;
            mat[rowStart][colStart] = leftBottomCornor;

        } else {

            //Handle Top row
            for (int i = colEnd - 1; i > colStart; i--) {
                mat[rowStart][i] = mat[rowStart][i - 1];
            }

            // Handle right column
            for (int i = rowEnd - 1; i > rowStart; i--) {
                if (i == rowStart + 1) mat[i][colEnd - 1] = rightTopCornor;
                else mat[i][colEnd - 1] = mat[i - 1][colEnd - 1];
            }

            // Handle bottom row
            for (int i = colStart; i < colEnd - 1; i++) {
                if (i == colEnd - 2) mat[rowEnd - 1][i] = rightBottomCornor;

                else mat[rowEnd - 1][i] = mat[rowEnd - 1][i + 1];
            }

            // Handle left column
            for (int i = rowStart; i < rowEnd - 1; i++) {
                if (i == rowEnd - 2) mat[i][colStart] = leftBottomCornor;
                else mat[i][colStart] = mat[i + 1][colStart];
            }
        }

        // Shrink all rows and columns for inner matrix.
        rowStart++;
        rowEnd--;
        colStart++;
        colEnd--;



        if(rowStart<rowEnd){
            rotateMatrixRec(mat,rowStart,rowEnd, colStart, colEnd);
        }

        return mat;
    }

    public static int[][] rotatedMatrix(int[][] mat){
        int rows = mat.length;
        int cols  = mat[0].length;

        rotateMatrixRec(mat, 0,rows, 0, cols);



        return mat;
    }

    public static void main(String args[]) {
        int mat[][] ={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int rotatedMat[][] = rotatedMatrix(mat);

        for(int i =0; i <rotatedMat.length; i++){
            for(int j =0; j< rotatedMat[0].length; j++){
               System.out.print(rotatedMat[i][j]+",");
            }
            System.out.println();
        }
    }


}
