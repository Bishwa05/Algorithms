package tree.binarytree.traversal;

import tree.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 *
 * Example 2:
 *
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 *
 */
public class CountGoodNodesInBinaryTree {
    int res = 0;
    public int goodNodes(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = root.val;
        preOrder(root, arr);
        return res;
    }

    private void preOrder(TreeNode root, int[] arr) {
        if (root != null) {
            int pathVal = arr[0];
            if (root.val > arr[0]) {
                arr[0] = root.val;
            }
            if (root.val == arr[0]) {
                res+=1;
            }
            preOrder(root.left, arr);
            preOrder(root.right, arr);
            arr[0] = pathVal;
        }
    }
}
