package array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Leetcode
 *
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 */
public class RemoveDuplicateII {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int x = 1;

        for (int i = 1; i < nums.length; i++) {
            p2++;

            System.out.println(p1 + "|" + p2 + "|" + x);
            if (nums[i] != nums[i - 1]) {
                x = 1;
                p1++;
                nums[p1] = nums[p2];
            } else {
                x++;
            }

            if (x == 2) {
                p1++;
                nums[p1] = nums[p2];
            }


        }
        return p1 + 1;

    }

}
