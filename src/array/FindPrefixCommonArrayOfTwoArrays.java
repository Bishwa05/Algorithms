package array;

/**
 * You are given two 0-indexed integer permutations A and B of length n.
 *
 * A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
 *
 * Return the prefix common array of A and B.
 *
 * A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,3,2,4], B = [3,1,2,4]
 * Output: [0,2,3,4]
 * Explanation: At i = 0: no number is common, so C[0] = 0.
 * At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
 * At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
 * At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
 *
 */
public class FindPrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        int[] frequency = new int[n+1];
        int commonCount = 0;

        // Iterate through the elements of both arrays
        for(int curr = 0; curr < n; ++ curr) {
            // Increment frequency of current elements in A and B
            // Check if the element in A has appeared before (common in prefix)
            frequency[A[curr]] +=1;
            if (frequency[A[curr]] == 2) ++commonCount;

            // Check if the element in B has appeared before (common in prefix)
            frequency[B[curr]] +=1;
            if (frequency[B[curr]] == 2) ++commonCount;

            // Store the count of common elements for the current prefix
            prefixCommonArray[curr] = commonCount;
        }
        // Return the final array with counts of common elements in each prefix
        return prefixCommonArray;
    }

    public static void main(String[] args) {
        FindPrefixCommonArrayOfTwoArrays f = new FindPrefixCommonArrayOfTwoArrays();
        int[] A = new int[] {1,3,2,4};
        int[] B = new int[] {3,1,2,4};

        int[] res = f.findThePrefixCommonArray(A, B);
    }
}
