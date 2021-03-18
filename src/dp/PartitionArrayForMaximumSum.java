package dp;

public class PartitionArrayForMaximumSum
{
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for(int i =0; i< arr.length; i++){
            if(i-k>=0){
                max = arr[i];
                for(int j = i-1; j>= i-k; j--){
                    dp[i] = Math.max(dp[i], dp[j] + (i-j)*max);
                    max = Math.max(max, arr[j]);
                }
            } else {
                max = Math.max(max, arr[i]);
                dp[i] = max*(i+1);
            }
        }
        return dp[arr.length-1];
    }

    public static void main(String arg[]){
        int arr[] = {1,15,7,9,2,5,10};
        PartitionArrayForMaximumSum p = new PartitionArrayForMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(arr, 3));
    }
}
