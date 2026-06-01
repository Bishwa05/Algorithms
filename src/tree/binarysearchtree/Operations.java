package tree.binarysearchtree;

import java.util.*;

public class Operations
{
    /**
     * 1305. All Elements in Two Binary Search Trees
     * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
     *
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> firstList = new ArrayList<>();

        getAllElementsRec(root1, firstList);
        getAllElementsRec(root2, firstList);
        Collections.sort(firstList);
        return firstList;

    }

    public void getAllElementsRec(TreeNode root1,List<Integer> elementsList){
        if(root1 != null){

            getAllElementsRec(root1.left, elementsList);
            elementsList.add(root1.val);
            getAllElementsRec(root1.right, elementsList);

        }
    }

    //Another efficient approach
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2){
        List<Integer> out = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        helper1(root1, queue);
        helper2(root2, queue, out);
        while(!queue.isEmpty()){
            out.add(queue.poll());
        }
        return out;
    }

    public void helper2(TreeNode root2, Queue<Integer> queue, List<Integer> out){
        if(root2 == null) return;

        helper2(root2.left, queue, out);

        while(!queue.isEmpty() && root2.val>=queue.peek()){
            out.add(queue.poll());
        }
        out.add(root2.val);
        helper2(root2.right, queue, out);
    }

    public void helper1(TreeNode root1, Queue<Integer>queue){
        if(root1 == null) return;

        helper1(root1.left, queue);
        queue.offer(root1.val);
        helper1(root1.right, queue);
    }

    /**
     * 669. Trim a Binary Search Tree
     * https://leetcode.com/problems/trim-a-binary-search-tree/
     *
     * When \text{node.val > high}node.val > high, we know that the trimmed binary tree must occur to the left of the node.
     * Similarly, when \text{node.val < low}node.val < low, the trimmed binary tree occurs to the right of the node.
     * Otherwise, we will trim both sides of the tree.
     */
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root == null) return null;
        if(root.val>high) return trimBST(root.left, low, high);
        if(root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * 538. Convert BST to Greater Tree
     * https://leetcode.com/problems/convert-bst-to-greater-tree/
     *
     */

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum+=root.val;
            root.val = sum;
            convertBST(root.left);
        }

        return root;
    }

    /**
     * 99. Recover Binary Search Tree
     * https://leetcode.com/problems/recover-binary-search-tree/
     *
     *
     * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
     *
     *
     * Input: root = [1,3,null,null,2]
     * Output: [3,1,null,null,2]
     * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
     *
     */

    public void recoverTree(TreeNode root) {

    }
    
}
