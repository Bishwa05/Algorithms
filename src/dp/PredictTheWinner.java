package dp;

public class PredictTheWinner
{
    public boolean predictTheWinner(int[] nums) {
        if(nums.length ==1) return true;

        int maxSum= dfs(nums, 0, nums.length-1);

        return maxSum>=0;
    }

    public int dfs(int[] nums, int i, int j ){
        if(i ==j){
            return nums[j];
        } else{
            return Math.max(nums[j] - dfs(nums, i, j-1),
                nums[i] - dfs(nums, i+1, j));
        }
    }

    /**
     *
     * DP Method
     */
    public boolean predictTheWinnerDP(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = nums[i];
        }

        for(int len= 1; len< n; len++){
            for(int i =0; i<n-len; i++){
                int j = i+len;
                dp[i][j] = Math.max(nums[i]- dp[i+1][j],
                    nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >=0;
    }

    public boolean predictTheWinnerDP1D(int[] nums){
        if(nums == null) return true;
        int n = nums.length;
        if((n & 1) ==0) return true;
        int []dp = new int[n];
        for(int i = n-1; i>=0; i--){
            for(int j =i; j<n; j++){
                if(i==j){
                    dp[i] = nums[i];
                } else{
                    dp[j] = Math.max(nums[i] - dp[j],
                        nums[j]- dp[j-1]);
                }
            }
        }
        return dp[n-1] >=0;
    }


    public static void main(String arg[]){
        int[] nums = {1, 5, 233, 7};
        PredictTheWinner p = new PredictTheWinner();
        System.out.println(p.predictTheWinnerDP(nums));
    }

}
