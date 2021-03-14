package dp;

/*
Maximum subsequence sum such that no three are consecutive

Input: arr[] = {1, 2, 3}
Output: 5
We can't take three of them, so answer is
2 + 3 = 5

Input: arr[] = {3000, 2000, 1000, 3, 10}
Output: 5013
3000 + 2000 + 3 + 10 = 5013

Input: arr[] = {100, 1000, 100, 1000, 1}
Output: 2101
100 + 1000 + 1000 + 1 = 2101

Input: arr[] = {1, 1, 1, 1, 1}
Output: 4

Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output: 27


Input: arr[] = {1, 2, 3}
Output: 5
We can't take three of them, so answer is
2 + 3 = 5

Input: arr[] = {3000, 2000, 1000, 3, 10}
Output: 5013
3000 + 2000 + 3 + 10 = 5013

Input: arr[] = {100, 1000, 100, 1000, 1}
Output: 2101
100 + 1000 + 1000 + 1 = 2101

Input: arr[] = {1, 1, 1, 1, 1}
Output: 4

Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output: 27

In general,
// We have three cases
// 1) Exclude arr[i],  i.e.,  sum[i] = sum[i-1]
// 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
// 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1]
sum[i] = max(sum[i-1], sum[i-2] + arr[i],
             sum[i-3] + arr[i] + arr[i-1])

 */
public class MaxSubSequenceSum
{

    static int maxSumWO3Consec (int arr[])
    {
        int n = arr.length;
        int sumArr[] = new int[n];

        if (n >= 1)
            sumArr[0] = arr[0];

        if (n >= 2)
            sumArr[1] = arr[0] + arr[1];

        if (n > 2)
            sumArr[2] = Math.max(sumArr[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

        for (int i = 3; i < n; i++) {
            sumArr[i] = Math.max(
                sumArr[i - 1],
                Math.max(sumArr[i - 2] + arr[i], sumArr[i - 3] + arr[i] + arr[i - 1]));
        }

        return sumArr[n - 1];

    }

    public static void main (String arg[])
    {
        int arr[] = { 100, 1000, 100, 1000, 1 };

        System.out.println(maxSumWO3Consec(arr));
    }
}
