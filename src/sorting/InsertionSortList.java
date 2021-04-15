package sorting;

import java.util.List;

/**
 * Leetcode
 * 147 Insertion Sort List
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class InsertionSortList
{
    public ListNode insertionSortList(ListNode head) {
        ListNode start = new ListNode(Integer.MIN_VALUE);
        start.next = head;
        ListNode curr = head, prev = start;
        while (curr != null) {
            if(curr.next != null && curr.next.val <curr.val){
                while(prev.next != null && prev.next.val < curr.next.val){
                    prev = prev.next;
                    ListNode temp = prev.next;
                    prev.next = curr.next;
                    curr.next = curr.next.next;
                    prev.next.next = temp;
                    prev = start;
                }
            } else{
                curr = curr.next;
            }

        }
        return start.next;
    }

    public static void main(String arg[]){
        ListNode head = new ListNode(9);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);

        InsertionSortList i = new InsertionSortList();
        ListNode sorted = i.insertionSortList(head);
        System.out.println(sorted);

    }

}
