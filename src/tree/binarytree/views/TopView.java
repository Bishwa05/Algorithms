package tree.binarytree.views;


import tree.binarytree.TreeNode;

import java.util.*;

public class TopView
{

    public static List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap keeps the columns sorted automatically from left to right
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Two parallel queues mean we don't need a wrapper class
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();

        // Initialize with the root node at column 0
        nodeQueue.add(root);
        hdQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int hd = hdQueue.poll();

            // If this column hasn't been filled yet, lock in this node
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, currNode.val);
            }

            // Left child: column shifts left (-1)
            if (currNode.left != null) {
                nodeQueue.add(currNode.left);
                hdQueue.add(hd - 1);
            }

            // Right child: column shifts right (+1)
            if (currNode.right != null) {
                nodeQueue.add(currNode.right);
                hdQueue.add(hd + 1);
            }
        }

        // Collect the final sorted results
        result.addAll(topViewMap.values());
        return result;
    }


    /**
     * Recursive way
     *
     */


    // Pair class to store both the node value and its depth/height in the tree
    static class NodePair {
        int data;
        int height;

        public NodePair(int data, int height) {
            this.data = data;
            this.height = height;
        }
    }


    // TreeMap keeps horizontal distances sorted from left to right automatically
    private static TreeMap<Integer, NodePair> topViewMap = new TreeMap<>();

    private static void getTopViewRecursive(TreeNode root, int hd, int height) {
        if (root == null) return;

        // If column is unvisited, OR we found a node closer to the top for this column
        if (!topViewMap.containsKey(hd) || height < topViewMap.get(hd).height) {
            topViewMap.put(hd, new NodePair(root.val, height));
        }

        // Traverse left: HD decreases, Height increases
        getTopViewRecursive(root.left, hd - 1, height + 1);

        // Traverse right: HD increases, Height increases
        getTopViewRecursive(root.right, hd + 1, height + 1);
    }

    public static List<Integer> topView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        topViewMap.clear(); // Clear static map for fresh execution

        // Start recursion with root at HD=0 and Height=0
        getTopViewRecursive(root, 0, 0);

        // Extract values from the sorted map
        for (NodePair pair : topViewMap.values()) {
            result.add(pair.data);
        }

        return result;
    }

    public static void main(String arg[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        TopView t = new TopView();

        t.topView2(root).forEach(e->{
            System.out.println(e);
        });

    }
}
