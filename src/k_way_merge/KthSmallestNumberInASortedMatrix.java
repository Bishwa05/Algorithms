package k_way_merge;

import java.util.PriorityQueue;

/**
 * Given an N * N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.
 *
 * Example 1:
 *
 * Input: Matrix=[
 *     [2, 6, 8],
 *     [3, 7, 10],
 *     [5, 8, 11]
 *   ],
 *   K=5
 * Output: 7
 * Explanation: The 5th smallest number in the matrix is 7.
 */
public class KthSmallestNumberInASortedMatrix {

    class Node {
        int value, row, col;
        Node(int v, int r, int c) {
            value = v;
            row = r;
            col = c;
        }
    }

    public int findKthSmallest(int[][] matrix, int k) {
        int result = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value-b.value);

        for (int i = 0 ; i < matrix.length; i++) {
            Node node = new Node(matrix[i][0], i, 0);
            minHeap.offer(node);
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = node.value;
            if (++count == k) break;

            if (node.col + 1 < matrix[0].length) {
                minHeap.add(new Node(matrix[node.row][node.col+1], node.row, node.col+1));
            }
        }

        return result;
    }
}
