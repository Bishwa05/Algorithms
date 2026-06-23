package tree.binarytree.traversal;

import java.util.Stack;

import tree.binarytree.TreeNode;

/**
 *
 * Left --> Right --> Root
 */
public class PostOrderTraversal {
	
	public void postOrderRec(TreeNode root) {
		if(root != null) {
			postOrderRec(root.right);
			postOrderRec(root.left);
			System.out.println(root.data);
		}
	}
	
	public void postOrderItr(TreeNode root) {
		if(root == null) {
			System.out.println("[]");
		}else {
			Stack<TreeNode> s = new Stack<>();
			s.push(root);
			TreeNode prev = null;
			
			while(!s.isEmpty()) {
				TreeNode curr = s.peek();
				if(prev==null || prev.left == curr || prev.right == curr) {
					if(curr.left != null)
						s.push(curr.left);
					else if(curr.right != null)
						s.push(curr.right);		
				} else if(curr.left ==prev) {
					if(curr.right != null)
						s.push(curr.right);
				} else {
					System.out.println(curr.data);
					s.pop();
				}
				prev = curr;
			}
		}
	}

}
