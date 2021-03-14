package dp;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets
{
    public boolean canPartitionKSubsets(int[] nums, int k) {
       int sum = Arrays.stream(nums).sum();
       if(sum % k >0) return false;
       int target = sum/k;

       Arrays.sort(nums);

       int row = nums.length -1;
       if(nums[row] > target) return false;

       while(row >=0 && nums[row] == target){
           row--;
           k--;
       }
        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target){
        if(row <0) return true;
        int v = nums[row--];
        count++;
        for(int i =0; i<groups.length; i++){
            if(groups[i] +v <= target){
                groups[i]+=v;

                if(search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if(groups[i] == 0) break;
        }
        return false;
    }

    /**
     * Another approach
     */
    public boolean canPartitionKSubsetsRec(int[] nums, int k){
        int sum = 0;
        if(k == 0) return true;

        if(nums.length < k) return false;

        for(int num: nums){
            sum+=num;
        }

        if(sum%k !=0) return false;

        boolean[] used = new boolean[nums.length];
        return util(nums, used, sum/k, 0, k, 0);
    }

    static int count =0;
    public boolean util(int[] nums, boolean[] used, int sum, int currSum, int k, int sr){
        //base condition, only 1 partition remaining, so no need to recurse further
        if(k==1)
            return true;
        //count++;

        /**
         * if currentSum == sum, recursively carry on the
         * procedure for further partitions
         */
        if(currSum == sum)
            return util(nums, used, sum, 0, k-1, 0);

        /**
         * for every other element apply backtracking by including the element
         * in the current partition and then excluding it
         */
        for(int i = sr; i <= nums.length; i++){
            if(!used[i] && currSum+nums[i]<= sum){
                used[i] = true;
                if(util(nums, used, sum, currSum+ nums[i], k, i+1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String arg[]){
        PartitionToKEqualSumSubsets p = new PartitionToKEqualSumSubsets();
        int []nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(p.canPartitionKSubsets(nums, 4));
        System.out.println(count);
    }
}
