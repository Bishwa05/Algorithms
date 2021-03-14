package dp;

/**
 * 413. Arithmetic Slices
 * Leetcode
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 */
public class ArithmeticSlices
{

    /**
     * Brute force
     */
    public int numberOfArithmeticSlicesBF (int[] A)
    {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];

            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    /**
     * Recursive approach.
     * time complexity O(n).
     */
    public int numberOfArithmeticSlicesRec (int[] arr)
    {
        int[] sum = new int[1];
        slices(arr, arr.length - 1, sum);
        return sum[0];
    }

    public int slices (int[] arr, int n, int[] sum)
    {
        if (n < 2) {
            return 0;
        }
        int ap = 0;

        if (arr[n] - arr[n - 1] == arr[n - 1] - arr[n - 2]) {
            ap = 1 + slices(arr, n - 1, sum);
            sum[0] = sum[0] + ap;
        }
        else {
            slices(arr, n - 1, sum);
        }
        return ap;
    }

    public int numberOfArithmeticSlices (int[] A)
    {
        int startSlice = 0;
        int total = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                total += 1 + i - 3 - startSlice + 1;
            }
            else {
                startSlice = i - 1;
            }
        }
        return total;
    }

    public int numberOfArithmeticSlicesSimple (int[] a)
    {
        int len = a.length;
        int dp[] = new int[len];
        int sum = 0;
        if (a.length < 3) {
            return 0;
        }

        for (int i = 2; i < len; i++) {
            if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main (String arg[])
    {
        int arr[] = { 1, 2, 3, 8, 9, 10 };
        ArithmeticSlices a = new ArithmeticSlices();
        System.out.println(a.numberOfArithmeticSlicesRec(arr));
    }

}
