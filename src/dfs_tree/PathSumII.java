package dfs_tree;
/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 *
 */

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        findPathsRec(root, sum, currPath, allPaths);
        return allPaths;
    }

    private void findPathsRec(TreeNode node, int sum, List<Integer> currPath, List<List<Integer>> allPaths) {
        if (node == null) return;
        //  add the current node to the path
        currPath.add(node.val);
        // if the current node is a leaf and its value is equal to sum, save the current path
        if (node.left == null && node.right == null && node.val == sum) {
            allPaths.add(new ArrayList<Integer>(currPath));
        } else {
            // traverse the left sub-tree
            findPathsRec(node.left, sum - node.val, currPath, allPaths);
            // traverse the right sub-tree
            findPathsRec(node.right, sum - node.val, currPath, allPaths);
        }
        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack
        currPath.remove(currPath.size()-1);

    }

    public static void main(String[] args) {
        PathSumII sol = new PathSumII();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = sol.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}

