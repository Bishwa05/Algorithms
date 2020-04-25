package dynamic;
/**
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 *
 *
 This Problem is similar https://leetcode.com/problems/partition-equal-subset-sum/

 Here instead of equal subset, have to find nearly equal subsets.
 Difference between those nearly equal subset is the final answer
 */
public class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int x: stones)
            total += x;

        int half = total/2;
        boolean[] dp = new boolean[half+1];
        dp[0] = true;

        for(int stone : stones){
            for(int sum=half; sum>=0;sum--){
                if(sum >= stone){
                    dp[sum] = dp[sum] || dp[sum-stone];
                }
            }
        }
        //Get the maximum possible partitionValue
        int partitionValue=0;
        for(int i=half;i>=0;i--){
            if(dp[i]){
                partitionValue = i;
                break;
            }
        }
        int secondHalf = total-partitionValue;
        return (secondHalf-partitionValue);
    }

    public static void main(String arg[]){
        //int []arr = {2,7,4,1,8,1};
        // int []arr = {1,1,4,2,2};
        int [] arr = {31,26,33,21,40};
        LastStoneWeight2 l = new LastStoneWeight2();
        System.out.println(l.lastStoneWeightII(arr));
    }
}
