package monotonic_stack;

import sorting.ListNode;

import java.util.Stack;

/**
 * Given the head node of a singly linked list, modify the list such that any node that has a node with a greater value to its right gets removed. The function should return the head of the modified list.
 *
 * Examples:
 *
 * Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
 * Output: 7 -> 4 -> 2 -> 1
 * Explanation: 5 and 3 are removed as they have nodes with larger values to their right.
 */
public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop(); // Remove nodes from the stack that are smaller than the current node
            }

            if (!stack.isEmpty()) {
                stack.peek().next = curr; // Update the next pointer of the top node in the stack
            }

            stack.push(curr); // Push the current node onto the stack
            curr= curr.next;
        }
        return stack.isEmpty()? null : stack.get(0); // Return the head of the modified list, or null if the stack is empty
    }
}
