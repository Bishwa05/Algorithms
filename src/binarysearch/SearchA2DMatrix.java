package binarysearch;

/**
 * 74. Search a 2D Matrix
 * Leetcode
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 */
public class SearchA2DMatrix
{
    /**
     * Approach 1
     */
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length ==0) return false;
        if(matrix[0].length ==0) return false;

        //get a row
        boolean found = false;
        int row =0;
        for(int i =0; i< matrix.length; i++){
            if(matrix[i][0] == target){
                found = true;
                break;
            } else if( matrix[i][0]< target){
                row = i;
            } else{
                break;
            }
        }

        if(!found){
            for(int i =0; i< matrix[0].length; i++){
                if(matrix[0][i] == target){
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    /**
     * Approach 2
     */

    public boolean searchMatrix2(int [][] matrix, int target){
        if(matrix.length ==0) return false;
        if(matrix[0].length ==0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int left =0;
        int right = m * n -1;

        while(left <= right){
            int mid = left+right <<1;
            if(matrix[mid/n][mid%n] == target) return true;
            else if(matrix[mid/n][mid%n] > target) right = mid -1;
            else left = mid + 1;
        }
        return false;
    }
}
