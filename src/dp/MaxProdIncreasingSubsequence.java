package dp;

/**
 * Input : arr[] = { 3, 100, 4, 5, 150, 6 }
 * Output : 45000
 * Maximum product is 45000 formed by the
 * increasing subsequence 3, 100, 150.
 */
public class MaxProdIncreasingSubsequence
{

    public static long getMaxIncrProd (int arr[])
    {
        long maxProd = 1;

        long maxProdArr[] = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            maxProdArr[i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && (arr[i] * maxProdArr[j]) > maxProdArr[i]) {
                    maxProdArr[i] = arr[i] * maxProdArr[j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(maxProdArr[i]);
            if (maxProd < maxProdArr[i])
                maxProd = maxProdArr[i];
        }

        return maxProd;
    }

    public static void main (String arg[])
    {
        int arr[] = { 3, 100, 4, 5, 150, 6 };
        System.out.println(getMaxIncrProd(arr));
    }
}
