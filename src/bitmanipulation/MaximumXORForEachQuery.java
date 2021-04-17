package bitmanipulation;

/**
 *  Leetcode
 * 1829. Maximum XOR for Each Query
 * You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:
 *
 * Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
 * Remove the last element from the current array nums.
 * Return an array answer, where answer[i] is the answer to the ith query.
 *
 * Example 1:
 *
 * Input: nums = [0,1,1,3], maximumBit = 2
 * Output: [0,3,2,3]
 * Explanation: The queries are answered as follows:
 * 1st query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
 * 2nd query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
 * 3rd query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
 * 4th query: nums = [0], k = 3 since 0 XOR 3 = 3.
 *
 */
public class MaximumXORForEachQuery
{

    public int[] getMaximumXor(int[] A, int bits) {
        int n = A.length;
        int[] res = new int[n];
        int k = (int)Math.pow(2, bits)-1;
        if(n<1) return res;

        int xor = A[0];
        res[n-1] = xor ^ k;
        if(n<2) return res;

        for(int i=1;i<A.length;i++){
            xor ^= A[i];
            res[n-i-1] = xor ^ k;
        }
        return res;
    }


    public static void main(String arg[]){
        MaximumXORForEachQuery m= new MaximumXORForEachQuery();
        int []nums = {2,3,4,7};
        int maximumBit = 3;
        m.getMaximumXor(nums, maximumBit);
    }
}
