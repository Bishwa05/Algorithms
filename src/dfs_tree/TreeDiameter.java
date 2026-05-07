package dfs_tree;

public class TreeDiameter {
    private int treeDiameter = 0;
    public int findDiameter(TreeNode root) {
        treeDiameter = 0;
        calculateHeight(root);
        return treeDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // if the current node doesn't have a left or right subtree, we can't have
        // a path passing through it, since we need a leaf node on each side
        if (leftHeight != 0 && rightHeight != 0) {
            // diameter at the current node will be equal to the height of left subtree +
            // the height of right sub-trees + '1' for the current node
            int diameter = leftHeight + rightHeight +1;

            // update the global tree diameter
            treeDiameter = Math.max(diameter, treeDiameter);
        }
        // height of the current node will be equal to the maximum of the heights of
        // left or right subtrees plus '1' for the current node
        return Math.max(leftHeight, rightHeight) +1;
    }
}
