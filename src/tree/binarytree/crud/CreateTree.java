package tree.binarytree.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tree.binarytree.TreeNode;

public class CreateTree {
	
	/**
	 * Construct a binary tree from Inorder and PreOrder traversals
	 *  Inorder sequence : D B E A F C
	 *  Preorder sequence : A B D E C F, Root A
	 *
	 *  Leetcode
	 *  105. Construct Binary Tree from Preorder and Inorder Traversal
	 */
	int preOrderIndex;
	Map<Integer, Integer> inorderIndexMap;
	public TreeNode buildBinaryTree(int[] preOrder, int[] inOrder) {
		preOrderIndex = 0;
		inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++){
			inorderIndexMap.put(inOrder[i], i);
		}
		if(preOrder.length ==0|| inOrder.length != preOrder.length)
			return null;
		return buildBT(preOrder, 0, preOrder.length-1);
	}

	private TreeNode buildBT(int[] preOrder, int left, int right) {

		if(left > right) return null;

		int rootValue = preOrder[preOrderIndex];
		preOrderIndex++;
		TreeNode root = new TreeNode(rootValue);
		root.left = buildBT(preOrder, left, inorderIndexMap.get(rootValue) -1);
		root.right =buildBT(preOrder, inorderIndexMap.get(rootValue)+1, right);
		return root;
	}
	
	/**
	 * Construct a binary tree from inOrder and postOrder traversals
	 *
	 * 106. Construct Binary Tree from Inorder and Postorder Traversal
	 *
	 */
	public TreeNode buildBinaryTree2(int[] inOrder, int[] postOrder) {
		if(postOrder.length ==0|| inOrder.length != postOrder.length)
			return null;
		return buildBT2(postOrder, 0, postOrder.length-1, inOrder,0, inOrder.length-1);
	}

	private TreeNode buildBT2(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd) {

		if(postStart>postEnd || inStart>inEnd)
			return null;
		int data = postOrder[postEnd];
		int offset = inStart;
		TreeNode curr = new TreeNode(data);
		for(;offset <inEnd; offset++) {
			if(inOrder[offset]== data)
				break;
		}
		
		curr.left = buildBT2(postOrder,postStart,postStart+offset-inStart-1, inOrder,inStart,offset-1);
		curr.right = buildBT2(postOrder, postStart+offset-inStart, postEnd-1, inOrder, offset+1, inEnd);
		return curr;
	}
	
	/**
	 * The following combination can uniquely identify a tree
	 * Inorder and preorder
	 * Inorder and postOrder
	 * Inorder and LevelOrder
	 */

	
	/*
	 * How many different trees possible from n nodes
	 * 2^n -n
	 */
	public int noOfBSTs(int n) {
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		for(int i=2; i<= n; i++) {
			for(int j=0; j<i; j++) {
				count[i] = count[j] * count[i-j-1];
			}
		}
		return count[n];
	}
	
	public ArrayList<TreeNode> generateTrees(int n){
		if(n == 0)
			return generateTrees(1,0);
		return generateTrees(1,n);
	}

	private ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> subTrees = new ArrayList<>();
		
		if(start>end) {
			subTrees.add(null);
			return subTrees;
		}
		
		for(int i= start; i<= end; i++) {
			for(TreeNode left: generateTrees(start, i-1)) {
				for(TreeNode right: generateTrees(i+1, end)) {
					TreeNode tmp = new TreeNode(i);
					tmp.left= left;
					tmp.right =right;
					subTrees.add(tmp);
				}
			}
		}
		return subTrees;
	}
}
