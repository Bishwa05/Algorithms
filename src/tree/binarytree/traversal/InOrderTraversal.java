package tree.binarytree.traversal;

import java.util.Stack;

import tree.binarytree.TreeNode;

/**
 * 
 * @author i501895
 *	Left --> Root --> Right
 */
public class InOrderTraversal {

	public void inOrderRec(TreeNode root) {
		if(root != null) {
			inOrderRec(root.left);
			System.out.println(root.data);
			inOrderRec(root.right);
		}
	}
	
	public void inOrderItr(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode currNode = root;
		boolean done =false;
		
		while(!done) {
			if(currNode != null) {
				s.push(currNode);
				currNode = currNode.left;
			}else {
				if(s.isEmpty())
					done= true;
				else {
					currNode = s.pop();
					System.out.println(currNode.data);
					currNode = currNode.right;
				}
			}
		}
	}
}
