package tree.binarytree.crud;

import java.util.LinkedList;
import java.util.Queue;

import tree.binarytree.TreeNode;

public class InsertinBinaryTree {
	
	public TreeNode insertInBinaryTreeLevelOrderItr(TreeNode root, int data) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) {
				if(curr.left != null)
					q.offer(curr.left);
				else {
					curr.left = new TreeNode(data);
					return root;
				}
				if(curr.right != null)
					q.offer(curr.right);
				else {
					curr.right = new TreeNode(data);
					return root;
				}
			}
		}
		return root;
	}

	
	public void insertLevelOrderRec(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
		}else {
			insertHelperRec(root, data);
		}
	}


	private void insertHelperRec(TreeNode root, int data) {
		// TODO Auto-generated method stub
		if(root.left == null) {
			root.left = new TreeNode(data);
		} else {
			insertHelperRec(root.left, data);
		}
		if(root.right == null) {
			root.right = new TreeNode(data);
		} else {
			insertHelperRec(root.right, data);
		}
	}
}
