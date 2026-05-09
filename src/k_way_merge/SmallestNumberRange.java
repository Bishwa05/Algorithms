package k_way_merge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.
 *
 * Example 1:
 *
 * Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
 * Output: [4, 7]
 * Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
 *
 */
public class SmallestNumberRange {
    class Node {
        int value, listIndex, elementIndex;
        Node (int v, int l, int e){
            value = v;
            listIndex = l;
            elementIndex = e;
        }
    }

    public int[] findSmallestRange(List<List<Integer>> lists) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        int currentMax = Integer.MIN_VALUE;
        // 1. Initialize heap with the first element of each list
        for (int i = 0; i < lists.size(); i++) {
            int val = lists.get(i).get(0);
            minHeap.offer(new Node(val, i,0));
            currentMax = Math.max(currentMax, val);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        // 2. Process elements until one list is exhausted
        while(minHeap.size() == lists.size()) {
            Node minNode = minHeap.poll();
            int currentMin = minNode.value;

            // 3. Update result if current [min, max] is smaller
            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }

            // 4. Try to add the next element from the same list
            if (minNode.elementIndex + 1 < lists.get(minNode.listIndex).size()) {
                int nextVal = lists.get(minNode.listIndex).get(minNode.elementIndex+1);
                minHeap.offer(new Node(nextVal, minNode.listIndex, minNode.elementIndex+1));
                currentMax = Math.max(currentMax, nextVal); // Keep max updated
            } else {
                // If any list runs out, we can't form a range with all lists anymore
                break;
            }
        }
        return new int[] {rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        SmallestNumberRange sol = new SmallestNumberRange();
        List<List<Integer>> list = List.of(List.of(1, 5, 8),
                List.of(4, 12), List.of(7, 8, 10));

        List<List<Integer>> list2 = List.of(List.of(1, 2, 3),
                List.of(4, 13, 6), List.of(7, 2, 7));

        int[] result = sol.findSmallestRange(list2);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
