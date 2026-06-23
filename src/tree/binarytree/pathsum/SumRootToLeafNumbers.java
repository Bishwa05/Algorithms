package tree.binarytree.pathsum;

import tree.leetcode.TreeNode;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumTree(root, 0);
    }

    public int sumTree(TreeNode node, int sum) {
        if(node==null) return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) return sum;
        return (sumTree(node.left, sum) + sumTree(node.right, sum));
    }


    // Another

    int sum = 0;
    int val = 0;
    public int sumNumbers2(TreeNode root) {
        if(root == null)
            return 0;

        val = val*10 + root.val;

        if(root.left == null && root.right == null) {
            sum += val;
        }

        sumNumbers2(root.left);
        sumNumbers2(root.right);
        val = val/10;

        return sum;
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sol = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " +
                sol.sumNumbers(root));
    }
}
