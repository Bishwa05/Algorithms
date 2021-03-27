package bitmanipulation;

public class MissingNumber
{
    public int missingNumber(int[] nums) {
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum+=(i+1);
        }

        for(int i=0; i<nums.length; i++){
            sum-=nums[i];
        }
        return sum;
    }

    public int missingNumberBM(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
