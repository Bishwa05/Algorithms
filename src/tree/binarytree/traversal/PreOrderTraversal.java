package tree.binarytree.traversal;

import java.util.Stack;

import tree.binarytree.BinaryTreeNode;

/**
 * 
 * @author i501895
 * Root--> Left-->Right
 */
public class PreOrderTraversal {
	
	public void preOrderRec(BinaryTreeNode root) {
		if(root != null) {
			System.out.println(root.data);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	
	public void preOrderItr(BinaryTreeNode root) {
		if(root == null) {
			System.out.println("[]");
		}else {
			Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
			s.push(root);
			
			while(!s.isEmpty()) {
				BinaryTreeNode tmp = s.pop();
				System.out.println(tmp);
				if(tmp.right != null)
					s.push(tmp.right);
				if(tmp.left != null)
					s.push(tmp.left);
				
			}
		}
	}


	/**
	 * Pseudo-Palindromic Paths in a Binary Tree
	 */

	int count = 0;
	public void preorder(BinaryTreeNode node, int path) {
		if (node != null) {
			// compute occurences of each digit
			// in the corresponding register
			System.out.println("Before : "+path);
			path = path ^ (1 << node.data);
			System.out.println("After : "+path);
			// if it's a leaf check if the path is pseudo-palindromic
			if (node.left == null && node.right == null) {
				// check if at most one digit has an odd frequency
				if ((path & (path - 1)) == 0) {
					++count;
				}
			}
			preorder(node.left, path);
			preorder(node.right, path) ;
		}
	}


	public int pseudoPalindromicPaths (BinaryTreeNode root) {
		preorder(root, 0);
		return count;
	}

	public static void main(String[] args) {

	}

}
