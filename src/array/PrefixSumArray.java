package array;

import java.util.Scanner;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.
 *
 * For example, the length of your array of zeros . Your list of queries is as follows:
 *
 *     a b k
 *     1 5 3
 *     4 8 7
 *     6 9 1
 * Add the values of  between the indices  and  inclusive:
 *
 * index->	 1 2 3  4  5 6 7 8 9 10
 * 	[0,0,0, 0, 0,0,0,0,0, 0]
 * 	[3,3,3, 3, 3,0,0,0,0, 0]
 * 	[3,3,3,10,10,7,7,7,0, 0]
 * 	[3,3,3,10,10,8,8,8,1, 0]
 *
 * 	The largest value is 10 after all operations are performed.
 */
public class PrefixSumArray {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < 3; j++) {
                queries[i][j] = sc.nextInt();
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

    }

    public static long arrayManipulation(int n, int [][] queries){
        long result;

        long arr[] = new long[n];

        for(int i = 0; i < queries.length; i++) {

            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            int val = queries[i][2];
            arr[startIndex-1] = arr[startIndex-1] + val;
            if(endIndex<n)
                arr[endIndex] = arr[endIndex] -val;
        }

        long max = Long.MIN_VALUE;
        for (int i=1; i<n; i++){
            arr[i] = arr[i-1]+arr[i];

            if(arr[i]>max)
                max = arr[i];
        }

        return max;
    }
}
