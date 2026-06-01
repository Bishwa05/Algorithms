package tree.binarytree;

import tree.binarysearchtree.TreeNode;

/**
 *
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * Leetcode 968. Binary Tree Cameras
 */
public class BinaryTreeCameras {
    int count = 0;

    public int minCameraCover(TreeNode root) {
        return dfs(root) == 2? count+1 : count;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 1;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left ==2 || right == 2) {
            count ++;
            return 3;
        }

        if(left == 3 || right ==3) return 1;

        return 2;
    }
}
