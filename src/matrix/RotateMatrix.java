package matrix;

/**
 * Rotate a matrix clockwise by 1 element clockwise
 */
public class RotateMatrix {

    public static int[][] rotateMatrixRec(int[][] mat, int rowStart, int rowEnd, int colStart, int colEnd){

        int rightTopCornor =  mat[rowStart][colEnd-1];
        int rightBottomCornor =  mat[rowEnd-1][colEnd-1];
        int leftBottomCornor =  mat[rowEnd-1][colStart];


        if(rowEnd-rowStart==2) {
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

    public static int[][] rotatedMatrixBy1Element(int[][] mat){
        int rows = mat.length;
        int cols  = mat[0].length;

        rotateMatrixRec(mat, 0,rows, 0, cols);

        return mat;
    }

    //Assuming a square matrix
    public static int[][] rotatedMatrix1ElementByInSubSquare(int[][] mat) {
        int rows = mat.length;
        int cols  = mat[0].length;

        int subSqrRows= (int) Math.sqrt(rows);
        int subSqrCols = (int) Math.sqrt(cols);

        for(int i =0; i<subSqrRows; i++){
            for(int j =0; j<subSqrCols; j++){
                int rowStart = i*subSqrRows;
                int rowEnd = rowStart+ subSqrRows;
                int colStart = j*subSqrCols;
                int colEnd = colStart+ subSqrCols;
                rotateMatrixRec(mat,rowStart,rowEnd,colStart,colEnd);
            }

        }
        return mat;
    }

    /**
     *
     * Anti clockwise
     * int x = mat[0][0];
     * mat[0][0] = mat[0][2];
     * mat[0][2] = mat[2][2];
     * mat[2][2] = mat[2][0];
     * mat[2][0]  = x;
     *
     * //        int x = mat[0][1];
     * //        mat[0][1] = mat[1][0];
     * //        mat[1][0] = mat[2][1];
     * //        mat[2][1] = mat[1][2];
     * //        mat[1][2]  = x;
     *
     *
     *
     *
     * @param mat
     * @return
     */

    public static int[][] rotateMatrixBy90Degree(int mat[][]) {

        int rows = mat.length;
        int cols = mat[0].length;

        for(int i =0; i< cols/2; i++) {
            for(int j =i;  j<rows-i-1; j++) {
                int temp = mat[i][j]; //  temp = mat[0][0]
                mat[i][j] = mat[cols - 1 - j][i]; // mat[0][0] = mat[2][0]
                mat[cols - 1 - j][i] = mat[cols - 1 - i][cols - 1 - j]; //mat[2][0] = mat[2][2]
                mat[cols - 1 - i][cols - 1 - j] = mat[j][cols - 1 - i]; // mat[2][2] = mat[0][2]
                mat[j][cols - 1 - i] = temp; // mat[0][2] = temp
            }

        }


        return mat;
    }

    public static void main(String args[]) {
        int mat[][] ={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };


        int mat1[][] ={
                {1,2,3,4,5,6,7,8,9},
                {10,11,12,13,14,15,16,17,18},
                {19,20,21,22,23,24,25,26,27},
                {28,29,30,31,32,33,34,35,36},
                {37,38,39,40,41,42,43,44,45},
                {46,47,48,49,50,51,52,53,54},
                {55,56,57,58,59,60,61,62,63},
                {64,65,66,67,68,69,70,71,72},
                {73,74,75,76,77,78,79,80,81}
        };

        int mat2[][] ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        //int rotatedMat[][] = rotatedMatrixBy1Element(mat2);

        // int rotatedMat[][] = rotatedMatrix1ElementByInSubSquare(mat1);

        int rotatedMat[][] = rotateMatrixBy90Degree(mat);

        for(int i =0; i <rotatedMat.length; i++){
            for(int j =0; j< rotatedMat[0].length; j++){
               System.out.print(rotatedMat[i][j]+",");
            }
            System.out.println();
        }
    }


}
