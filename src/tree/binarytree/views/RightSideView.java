package tree.binarytree.views;

import tree.binarysearchtree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Leetcode 199. Binary Tree Right Side View
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        printRightSideView(root, ans, 0);
        return ans;
    }

    private void printRightSideView(TreeNode root, List<Integer> list, int level) {
        if(root == null) {
            return;
        }

        if(list.size() == level){
            list.add(root.val);
        }

        printRightSideView(root.right, list, level+1);
        printRightSideView(root.left, list, level+1);
    }
}
