package dfs_tree;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 *
 */
public class SumOfPathNumbers {
    public int findSumOfPathNumbers(TreeNode root) {
        return findSumRec(root, 0);
       // return 0;
    }

    private int findSumRec(TreeNode node, int pathSum) {
        if (node == null) return 0;

        pathSum = pathSum*10 + node.val;

        if (node.left == null && node.right == null) return pathSum;

        return findSumRec(node.left, pathSum) + findSumRec(node.right, pathSum);

    }

    public static void main(String[] args) {
        SumOfPathNumbers sol = new SumOfPathNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " +
                sol.findSumOfPathNumbers(root));
    }
}
