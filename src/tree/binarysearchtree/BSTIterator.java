package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 *
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 *
 *
 * TODO:
 * Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
 *
 *
 */
public class BSTIterator {
    private int index;
    private List<Integer> elementList;

    public BSTIterator(TreeNode root) {
        index = 0;
        elementList = new ArrayList<>();
        inOrder(root, elementList);
    }

    public int next() {
        return elementList.get(index++);
    }

    public boolean hasNext() {
        return index < elementList.size();
    }

    private void inOrder(TreeNode root, List<Integer> elementList) {
        if(root == null) return;
        inOrder(root.left, elementList);
        elementList.add(root.val);
        inOrder(root.right, elementList);
    }
}
