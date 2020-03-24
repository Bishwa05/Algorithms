package array;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int nums[], int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for(int i=0; i<nums.length -2; i++) {
            int pointer1 = i+1;
            int pointer2 = nums.length -1;

            while(pointer1 < pointer2) {
                int currentSum = nums[i]+ nums[pointer1]+ nums[pointer2];
                if(currentSum > target){
                    pointer2 --;
                } else {
                    pointer1 ++;
                }

                if(Math.abs(currentSum- target)< Math.abs(result- target)){
                    result = currentSum;
                }
            }
        }
        return result;
    }

    public static void main(String arg[]) {
        int nums[] = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));

    }

}
