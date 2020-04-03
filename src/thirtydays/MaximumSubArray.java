package thirtydays;

public class MaximumSubArray {

    public static int maxSubArray(int arr[]){
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

    public static void main(String arg[]) {
        int arr1[] = {-2,1,-3,4,-1,2,1,-5,4};
        //  int arr1[] = {-2,-3,-1};
        System.out.println(maxSubArray(arr1));
    }
}
