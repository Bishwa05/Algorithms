package binarysearch;

public class MatrixMedian
{
    public int medianRowwiseSortedMatrix(int matrix[][]) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int M = matrix.length;
        int N = matrix[0].length;

        int desiredCount = (1+(M*N)/2);

        for(int i=0; i<M; i++){
            if(matrix[i][0]<min)
                min = matrix[i][0];
            if(matrix[i][N-1]>max)
                max = matrix[i][N-1];
        }

        int counter =0;
        while(min<max){
            counter =0;
            int mid = (max+min)/2;

//            for(int i=0; i<M; i++){
//                counter+= upper_bound(A[i])
//            }

            if(counter<desiredCount)
                min = mid+1;
            else
                max = mid;
        }
        return min;
    }

}
