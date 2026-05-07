package cyclicsort;

public class FindTheMissingNumber {
    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here

        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
