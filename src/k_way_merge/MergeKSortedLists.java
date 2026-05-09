package k_way_merge;

import sorting.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
 *
 * Example 1:
 *
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
 * Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 * Example 2:
 *
 * Input: L1=[5, 8, 9], L2=[1, 7]
 * Output: [1, 5, 7, 8, 9]
 */
public class MergeKSortedLists {
    public ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);



        // put the root of each list in the min heap
        for (ListNode root : lists) {
            if (root != null)
                minHeap.offer(root);
        }

        // take the smallest (top) element form the min-heap and add it to the result;
        // if the top element has a next element add it to the heap
        ListNode resultHead = null, resultTail = null;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (resultHead == null)
                resultHead = resultTail = node;
            else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if (node.next != null)
                minHeap.offer(node.next);
        }
        return resultHead;
    }

    public static void main(String[] args) {
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = sol.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
