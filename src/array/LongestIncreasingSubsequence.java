package array;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];

        int size = 0;
        for(int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i+j)/2;
                if(LIS[m]<x)
                    i = m+1;
                else
                    j = m;
            }
            LIS[i] = x;
            if (i == size) ++size;
        }
        return size;

    }

    public static void main(String[] args) {
        int[] nums = new int [] {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(nums));

    }
}
