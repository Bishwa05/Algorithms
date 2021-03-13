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

    public static void main(String arg[]){
        int[] nums = {1, 5, 233, 7};
        PredictTheWinner p = new PredictTheWinner();
        System.out.println(p.predictTheWinner(nums));
    }

}
