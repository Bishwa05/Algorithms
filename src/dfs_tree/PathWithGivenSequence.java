package dfs_tree;

public class PathWithGivenSequence {

    public boolean findPath(TreeNode root, int[] sequence) {
        if (root == null)
            return sequence.length == 0;
        return findPathRec(root, sequence, 0);
    }

    private boolean findPathRec(TreeNode node, int[] sequence, int index) {
        if (node == null) return false;
        if (index >= sequence.length || node.val != sequence[index]) return false;

        if (node.left == null && node.right == null && index == sequence.length -1 ) return true;

        return findPathRec(node.left, sequence, index+1) ||
                findPathRec(node.right, sequence, index+1);
    }
}
