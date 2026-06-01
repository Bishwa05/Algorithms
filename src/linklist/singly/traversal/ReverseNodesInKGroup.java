package linklist.singly.traversal;

import linklist.singly.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode curr = head, next = null, prev = null;
        int count = k;

        while (curr != null) {
            curr = curr.next;
            count--;
            if (count == 0) break;
        }

        if (count == 0) { // Not to reverse the last group if it is < k , if we want to reverse that we can do count >= 0
            curr = head;
            count = k;
        } else {
            return head;
        }

        // reverse
        while(curr != null & count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    //-----------------Iterative approach -------------------------

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode current = head, previous = null;
        while (true) {
            ListNode lastNodeOfPreviousPart = previous;
            // after reversing the LList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSubList = current;
            ListNode next = null; // will be used to temporarily store the next node
            // reverse 'k' nodes
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the previous part
            if (lastNodeOfPreviousPart != null)
                // 'previous' is now the first node of the sub-list
                lastNodeOfPreviousPart.next = previous;
            else // this means we are changing the first node (head) of the LinkedList
                head = previous;

            // connect with the next part
            lastNodeOfSubList.next = current;

            if (current == null) // break, if we've reached the end of the LinkedList
                break;
            // prepare for the next sub-list
            previous = lastNodeOfSubList;
        }

        return head;
    }

    //------------------------------------------------------------------------

    static void main() {
        int k = 2;
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = r.reverseKGroup(head, k);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
