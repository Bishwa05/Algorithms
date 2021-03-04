package slidingwindow;

public class SmallestSubArrayWithGivenSum
{
    public int findMinSubArray(int no, int []arr){
        int sum = 0, minLength = Integer.MAX_VALUE;
        int windowStart =0;
        for(int windowEnd =0; windowEnd < arr.length; windowEnd++){
            sum += arr[windowEnd];

            while(sum >= no){
                if(sum == no) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                }
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE?0:minLength;
    }
}
