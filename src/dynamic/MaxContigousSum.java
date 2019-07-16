package dynamic;

public class MaxContigousSum {

    public int maxContigousSum(int [] arr) {
        int maxSum = arr[0], sum =0;

        for(int i=0; i<arr.length; i++){
            sum = Math.max(sum+arr[i],arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxContigousSum2( int[] arr) {
        int sumTillNow=0, sumForNow =0;

        for(int i=0; i<arr.length; i++){
            sumForNow = sumForNow+ arr[i];
            if(sumForNow<0){
                sumForNow =0;
                continue;
            }

            if(sumTillNow< sumForNow) {
                sumTillNow = sumForNow;
            }
        }
        return sumTillNow;
    }

}
