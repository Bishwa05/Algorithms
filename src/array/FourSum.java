package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int [] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outputArr = new LinkedList<>();

        for(int i=0; i<nums.length-3; i++) {
            if(i==0 || nums[i] != nums[i-1]) {

                for(int j=i+1; j<nums.length-2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int low = j + 1;
                        int high = nums.length - 1;
                        int sum = 0 - nums[i] - nums[j];

                        while (low < high) {
                            if (nums[low] + nums[high] == sum) {
                                outputArr.add(Arrays.asList(nums[i],nums[j], nums[low], nums[high]));

                                while (low < high && nums[low] == nums[low + 1]) low++;
                                while (low < high && nums[high] == nums[high - 1]) high--;
                                low++;
                                high--;
                            } else if (nums[low] + nums[high] > sum) {
                                high--;
                            } else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return outputArr;
    }

    public static void main(String args[]){
        int nums[] = {1, 0, -1, 0, -2, 2};

        List<List<Integer>>output = fourSum(nums);

        if(output.size()>0){
            output.forEach((v) -> v.forEach((v2) -> System.out.println(v2)));
        }
    }
}
