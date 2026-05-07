package dfs_tree;

import java.util.HashMap;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class PathSumIII {
    int count = 0;
    int k;
    HashMap<Long, Integer> hashMap = new HashMap<>();

    public void preOrder(TreeNode node, long currSum) {
        if (node == null) return;

        // The current prefix sum
        currSum += node.val;

        // Here is ths sum we are looking for
        if (currSum == k) count++;

        // The number of times the curr_sum − k has occurred already,
        // determines the number of times a path with sum k
        // has occurred up to the current node
        count += hashMap.getOrDefault(currSum -k, 0);

        //Add the current sum into the hashmap
        // to use it during the child node's processing
        hashMap.put(currSum, hashMap.getOrDefault(currSum, 0) + 1);

        // Process the left subtree
        preOrder(node.left, currSum);

        // Process the right subtree
        preOrder(node.right, currSum);

        // Remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        hashMap.put(currSum, hashMap.get(currSum)-1);
    }

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preOrder(root, 0L);
        return count;
    }

    public static void main(String[] args) {
        PathSumIII sol = new PathSumIII();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + sol.pathSum(root, 11));
    }
}
