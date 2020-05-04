package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15 Leetcode,
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 
 */
public class ThreeSumToZero {

    public static List<List<Integer>> threeSum(int [] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outputArr = new LinkedList<>();

        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || nums[i] != nums[i-1]) {
                int low = i+1;
                int high = nums.length -1;
                int sum = 0 - nums[i];

                while(low<high) {
                    if(nums[low] + nums[high] == sum) {
                        outputArr.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if(nums[low]+nums[high]> sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return outputArr;
    }

    public static void main(String arg[]) {
        int nums[] = {-1,0,1,2,-1, -4};

        List<List<Integer>>output = threeSum(nums);

        if(output.size()>0){
            output.forEach((v) -> v.forEach((v2) -> System.out.println(v2)));
        }

    }
}
