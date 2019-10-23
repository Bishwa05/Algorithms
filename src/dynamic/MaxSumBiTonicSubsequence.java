package dynamic;

public class MaxSumBiTonicSubsequence {

    static int maxSumBS(int [] arr)
    {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        int mSIBS[] = new int[n];
        int mSIDS[] = new int[n];

        for (int i =0; i< n; i++) {
            mSIBS[i] = arr[i];
            mSIDS[i] = arr[i];
        }

        //Form Increasing Sub sequence
        for(int i =1; i<n ; i++){
            for(int j =0; j<i; j++){
                if(arr[i] > arr[j] && mSIBS[i] < mSIBS[j] +arr[i])
                    mSIBS[i] = mSIBS[j]+ arr[i];
            }
        }

        //Form Decreasing Sub sequence
        for(int i =n-2; i>=0 ; i--){
            for(int j = n-1; j>i; j--){
                if(arr[i] > arr[j] && mSIDS[i] < mSIDS[j] +arr[i])
                    mSIDS[i] = mSIDS[j]+ arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(mSIBS[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(mSIDS[i]+" ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, (mSIBS[i]+mSIDS[i]-arr[i]));
        }
        return maxSum;
    }

    /*
    Maximum sum Bi-tonic sub-sequence is 1 + 15 + 51 + 100 + 18 + 9 = 194
     */
    public static void main(String[] args)
    {
        int arr[] = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
        System.out.println("Maximum Sum : " + maxSumBS(arr));
    }
}
