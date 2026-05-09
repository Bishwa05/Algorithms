package k_way_merge;

import java.util.*;

/**
 * Given two sorted arrays in descending order, find ‘K’ pairs with the largest sum where each pair consists of numbers from both the arrays.
 *
 * Example 1:
 *
 * Input: nums1=[9, 8, 2], nums2=[6, 3, 1], K=3
 * Output: [9, 3], [9, 6], [8, 6]
 * Explanation: These 3 pairs have the largest sum. No other pair has a sum larger than any of these.
 *
 */
public class KPairsWithLargestSum {
    public static List<List<Integer>> kLargestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Max-Heap: {sum, i, j}. Sorted by sum descending.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Visited set to store "i,j" strings
        Set<String> visited = new HashSet<>();

        // 1. Start with the absolute largest pair
        maxHeap.add(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0,0");

        // 2. Extract k times
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int i = curr[1];
            int j = curr[2];
            result.add(List.of(nums1[i], nums2[j]));
            k--;

            // 3. Check next candidate from nums1 (i+1, j)
            if (i+1 < nums1.length && !visited.contains((i+1)+","+j)) {
                maxHeap.add(new int[]{nums1[i+1] + nums2[j], i+1, j});
                visited.add((i+1)+","+j);
            }

            // 4. Check next candidate from nums2 (i, j+1)
            if (j+1 < nums2.length && !visited.contains(i+","+(j+1))) {
                maxHeap.add(new int[]{nums1[i] + nums2[j+1], i, j+1});
                visited.add(i+","+(j+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KPairsWithLargestSum sol = new KPairsWithLargestSum();
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<List<Integer>> result = sol.kLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (List<Integer> pair : result)
            System.out.print(pair + " ");
    }
}
