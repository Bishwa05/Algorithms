package dynamic;

public class MaxSumIncreasingSubsequence {

    static int maxSum(int [] arr) {
        int n = arr.length;

        int [] mSIS=  new int[n];
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            mSIS[i] = arr[i];
        }

        for(int i =1; i<n; i++) {
            for(int j =0; j<i; j++) {
                if(arr[i] > arr[j] && mSIS[i] < mSIS[j]+arr[i]) {
                    mSIS[i] = mSIS[j] + arr[i];
                }
            }
        }

        for(int i =0; i<n; i++) {
            maxSum = Integer.max(maxSum, mSIS[i]);
        }
        return maxSum;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};

        System.out.println("Sum of maximum sum "+
                "increasing subsequence is "+
                maxSum(arr));
    }
}
