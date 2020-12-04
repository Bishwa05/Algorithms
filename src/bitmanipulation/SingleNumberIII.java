package bitmanipulation;

/**
 * Leetcode 260
 */
public class SingleNumberIII
{

    public int[] singleNumber(int[]nums){
        if(nums.length<3) return nums;

        int xor =0;
        for(int i =0; i<nums.length; i++){
            xor ^= nums[i];
        }

        xor &=-xor;
        int val1 =0;
        int val2 =0;

        for(int i=0; i<nums.length; i++){
            if((nums[i] & xor) !=0) val1 ^= nums[i];
            else val2 ^= nums[i];
        }
        return new int[]{val1, val2};
    }

    public static void main(String arg[]){
        SingleNumberIII s = new SingleNumberIII();
        int[] nums = {1,2,1,3,2,5};

        int [] res = s.singleNumber(nums);
        System.out.println(res[0] +"::"+ res[1]);
    }
}
