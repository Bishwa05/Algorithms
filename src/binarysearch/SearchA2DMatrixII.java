package binarysearch;

/**
 * Leetcode
 * 240. Search a 2D Matrix II
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 */
public class SearchA2DMatrixII
{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 ||
            matrix[0].length ==0) return false;

        int row = matrix.length -1;
        int col =0;

        while(row>=0 && col < matrix[0].length){
            if(matrix[row][col]> target){
                row--;
            } else if(matrix[row][col] < target){
                col ++;
            } else{
                return true;
            }
        }
        return false;
    }
}
