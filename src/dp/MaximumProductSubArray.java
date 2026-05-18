package dp;

public class MaximumProductSubArray
{
    public int maxProduct (int[] nums)
    {

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            }
            else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }

    public int maxProduct2 (int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int min = nums[0];
        int max = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(max*curr, min*curr));
            min = Math.min(curr, Math.min(min*curr, max*curr));
            max = temp;
            result = Math.max(result, max);
        }


        return result;
    }

    public static void main (String arg[])
    {
        int arr[] = { 2, 3, -2, 4 };
        MaximumProductSubArray m = new MaximumProductSubArray();
        System.out.println(m.maxProduct(arr));
    }
}
