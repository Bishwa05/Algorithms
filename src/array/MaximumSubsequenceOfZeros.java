package array;

/**
 * Find the max number of subsequence zeros.
 */
public class MaximumSubsequenceOfZeros {

    public int findMaxZeroSubSeq(int [] arr){
        int[] x = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i] ==0){
                x[i] = 1;
            } else{
                x[i]=0;
            }
        }
        int max =0;

        for(int i=1; i<x.length; i++){
            if(x[i] != 0) x[i]  += x[i-1];
            if(x[i] > max){
                max = x[i];
            }

        }
        return max;
    }

    public static void main(String arg[]){
        int arr[] ={0,1,1,0,0,0,1,1,0,0,1};
        MaximumSubsequenceOfZeros m = new MaximumSubsequenceOfZeros();
        System.out.println(m.findMaxZeroSubSeq(arr));
    }


}
