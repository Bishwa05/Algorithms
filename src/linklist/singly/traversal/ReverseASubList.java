package linklist.singly.traversal;

import linklist.singly.ListNode;

public class ReverseASubList {
    public ListNode reverse(ListNode head, int p, int q) {
        if (p == q) return head;

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode curr = head, prev = null;
        for (int i = 0; i< p-1 && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p', part
        // between 'p' and 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = prev; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = curr;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; i < q-p+1 && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null)
        // 'previous' is now the first node of the sub-list
            lastNodeOfFirstPart.next = prev;
        else
        // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = prev;

        // connect with the last part
        lastNodeOfSubList.next = curr;

        return head;
    }

    public static void main(String[] args) {
        ReverseASubList sol = new ReverseASubList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = sol.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
