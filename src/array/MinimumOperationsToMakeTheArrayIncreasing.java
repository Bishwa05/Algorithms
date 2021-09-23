package array;

public class    MinimumOperationsToMakeTheArrayIncreasing
{

    public int minOperations(int[] nums) {
        if(nums.length ==1) return 0;

        int prev = nums[0];
        int count = 0;

        for(int i = 1; i< nums.length; i++){
            if(prev>=nums[i]){
                int diff = prev-nums[i] +1;
                count += diff;
                prev = nums[i] + diff;
            } else {
                prev = nums[i];
            }
        }
        return count;
    }


    public static void main(String arg[]){
        MinimumOperationsToMakeTheArrayIncreasing m = new MinimumOperationsToMakeTheArrayIncreasing();
        int nums[] = {1,5,2,4,1};
        System.out.println(m.minOperations(nums));
    }
}
