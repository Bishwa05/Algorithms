package leetcodethirtydayschallenge;

public class MaximumSubArray {

    public static int maxSubArray(int arr[]){
        //Takes care of -ve and and single -ve element in array
        int maxSum = Integer.MIN_VALUE;
        int maxSumTillNow =0;
        boolean anyPositive =  false;

        for(int i : arr) {
            if(i>=0) {
                anyPositive= true;
            }

            if(i>maxSum){
                maxSum =i;
            }
        }

        if(!anyPositive) {
            return maxSum;
        }

        //Kadane's Algorithm
        maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            maxSumTillNow += arr[i];

            maxSumTillNow = Integer.max(maxSumTillNow, 0);

            if(maxSumTillNow>maxSum){
                maxSum = maxSumTillNow;
            }

        }

        return maxSum;
    }

    // function to find maximum sum of subarray crossing the middle element
    public static int maxCrossingSubarray(int ar[], int low, int mid, int high)
    {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int i;

        for (i=mid; i>=low; i--)
        {
            sum = sum+ar[i];
            if (sum>leftSum)
                leftSum = sum;
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (i=mid+1; i<=high; i++)
        {
            sum=sum+ar[i];
            if (sum>rightSum)
                rightSum = sum;
        }

        return (leftSum+rightSum);
    }


    //Divide and Conquer
    public static int maxSubArraySumDQ(int[] arr, int l, int r) {

        if (r == l) // only one element in an array
        {
            return arr[r];
        }

        // middle element of the array
        int mid = (r+l)/2;

        // maximum sum in the left subarray
        int maximumSumLeftSubarray = maxSubArraySumDQ(arr, l, mid);
        // maximum sum in the right subarray
        int maximumSumRightSubarray = maxSubArraySumDQ(arr, mid+1, r);
        // maximum sum in the array containing the middle element
        int maximumSumCrossingSubarray = maxCrossingSubarray(arr, l, mid, r);

        // returning the maximum among the above three numbers
        return Math.max(Math.max(maximumSumLeftSubarray, maximumSumRightSubarray), maximumSumCrossingSubarray);

    }

    public static void main(String arg[]) {
        //int arr1[] = {-2,1,-3,4,-1,2,1,-5,4};
        int arr1[] = {  -2, -3, -1};
       // System.out.println(maxSubArray(arr1));

        //Divide and conquer
        System.out.println(maxSubArraySumDQ(arr1,0, arr1.length-1));
    }
}
