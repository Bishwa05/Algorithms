package cyclicsort;

public class FindSmallestMissingPositiveNumber {

    // findNumber finds the smallest missing positive number in the array.
    public int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        // Find the first index where the element does not match its expected positive value.
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        // If all elements from 1 to nums.length are present, return nums.length + 1.
        return nums.length + 1;
    }

    // swap swaps the elements at indices i and j in the array.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        FindSmallestMissingPositiveNumber sol = new FindSmallestMissingPositiveNumber();
        System.out.println(
                sol.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(
                sol.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(
                sol.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
