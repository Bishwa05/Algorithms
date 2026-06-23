package tree.binarytree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binarytree.TreeNode;

public class OtherTraversals {
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> lTree = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return lTree;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		
		ArrayList<Integer>currlvl = new ArrayList<Integer>();
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr !=  null) {
				currlvl.add(curr.data);
				if(curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			} else {
				ArrayList<Integer> copyCurrLvl = new ArrayList<Integer>();
				copyCurrLvl.addAll(currlvl);
				lTree.add(copyCurrLvl);
				currlvl.clear();
				if(!q.isEmpty())
					q.offer(null);
			}
		}
		return lTree;
	}
	
	/**
	 * 
	 * @param root
	 * 
	 * 				1
	 * 			2		3
	 * 		4		5 6		7
	 * 
	 * --> 4 5 6 7 2 3 1
	 */
	public static void levelorderTraversalInReverse(TreeNode root) {
		if(root == null)
			return;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		Queue<TreeNode> q= new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr.left != null)
				q.offer(curr.left);
			if(curr.right != null)
				q.offer(curr.right);
			s.push(curr);
		}
		
		while(!s.isEmpty())
			System.out.println(s.pop().data+"");
	}
	
	public ArrayList<ArrayList<Integer>> zigZagLvlOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		boolean leftToRight = true;
		ArrayList<Integer> currList = new ArrayList<>();
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) {
				currList.add(curr.data);
				if(curr.left != null)
					q.offer(curr.left);
				if(curr.right != null)
					q.offer(curr.right);
			} else {
				if(leftToRight) {
					ArrayList<Integer> cCurrList = new ArrayList<>(currList);
					result.add(cCurrList);
					currList.clear();
				}else {
					Stack<Integer> s= new Stack<>();
					s.addAll(currList);
					ArrayList<Integer> cCurrList = new ArrayList<>();
					while(!s.isEmpty()) {
						cCurrList.add(s.pop());
					}
					result.add(cCurrList);
					currList.clear();
				}
				
				if(!q.isEmpty()) {
					q.offer(null);
					leftToRight = !leftToRight;
				}
			}
		}
		return result;
	}

}
