package array;

public class NextPermutation
{
    public void nextPermutation(int[] nums){
        int i = nums.length -2;
        while(i>=0 && nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){
            int j = nums.length -1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start){
        int i = start, j = nums.length -1;

        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String arg[]){
        int nums[] = {1,3,2};
        NextPermutation n = new NextPermutation();

        n.nextPermutation(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }
}
