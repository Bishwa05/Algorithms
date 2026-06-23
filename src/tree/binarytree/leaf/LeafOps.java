package tree.binarytree.leaf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.binarytree.TreeNode;

public class LeafOps {

	public int numberOfLeavesLvlOrder(TreeNode root) {
		int count =0;
		if(root == null)
			return count;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if(tmp.left == null && tmp.right == null)
				count++;
			if(tmp.left != null)
				q.offer(tmp.left);
			if(tmp.right != null)
				q.offer(tmp.right);
		}
		return count;
	}
	
	public int numberOfFullNodesLvlOrder(TreeNode root) {
		int count =0;
		if(root == null)
			return count;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if(tmp.left != null && tmp.right !=null)
				count++;
			if(tmp.left != null)
				q.offer(tmp.left);
			if(tmp.right != null)
				q.offer(tmp.right);
		}
		return count;
	}
	
	public int numberOfHalfNodesLvlOrder(TreeNode root) {
		int count =0;
		if(root == null)
			return count;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if((tmp.left == null && tmp.right !=null)||
					(tmp.left != null && tmp.right ==null))
				count++;
			if(tmp.left != null)
				q.offer(tmp.left);
			if(tmp.right != null)
				q.offer(tmp.right);
		}
		return count;
	}
	
	//print all the paths from root to leaf in a tree
	public void printPaths(TreeNode root) {
		int[] path = new int[256];
		printPaths(root,path,0);
	}

	private void printPaths(TreeNode root, int[] path, int pathLen) {
		if(root == null)
			return;
		//append this node to path array
		path[pathLen] = root.data;
		pathLen++;
		
		// its a leaf. So print the path that led to here
		if(root.left == null && root.right == null) {
			printArray(path, pathLen);
		} else {
			// otherwise try both subtrees
			printPaths(root.left, path, pathLen);
			printPaths(root.right, path, pathLen);
		}
	}
	
	public void printArray(int[] ints, int len) {
		for(int i=0; i<len; i++) {
			System.out.println(ints[i]+" ");
		}
		System.out.println();
	}


	// Done in leetcode 257. Binary Tree Paths
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();

		dfs(root, new ArrayList<>(), res);
		return res;
	}

	public void dfs(TreeNode root, List<Integer> temp, List<String> res){
		temp.add(root.data);
		if(root.left == null && root.right == null){
			StringBuilder sb = new StringBuilder();
			for(int i : temp) {
				sb.append(i).append("->");
			}
			sb.delete(sb.length()-2, sb.length());
			res.add(sb.toString());

		}

		if(root.left != null){
			dfs(root.left, temp, res);
			if(temp.size()>0)
				temp.remove(temp.size()-1);
		}
		if(root.right != null){
			dfs(root.right, temp, res);
			if(temp.size()>0)
				temp.remove(temp.size()-1);
		}

	}
	
	
	//Check the existence of path with given sum
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null && root.data == sum)
			return true;
		else
			return hasPathSum(root.left, sum-root.data) || hasPathSum(root.right, sum -root.data);
	}
	
	// find sum of all elements in a binary tree
	public int addBTRec(TreeNode root) {
		if(root == null)
			return 0;
		else
			return(root.data+addBTRec(root.left)+addBTRec(root.right));
	}
	
	// find sum of all elements in a binary tree itr
	public int addBTItr(TreeNode root) {
		int sum =0;
		if(root == null)
			return sum;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) {
				sum+= curr.data;
				if(curr.left != null)
					q.offer(curr.left);
				if(curr.right != null)
					q.offer(curr.right);
			}
		}
		return sum;
	}
	
	
	/**
	 * Print all ancestors of a node in a BinaryTree 
	 */
	public static boolean printAllAncestors(TreeNode root, TreeNode node) {
		if(root == null)
			return false;
		if(root.left == node || root.right == node ||
				printAllAncestors(root.left, node)|| printAllAncestors(root.right, node)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	


	/**
	 * 1302. Deepest Leaves Sum
	 * Leetcode.
	 */
	public int deepestLeavesSum(TreeNode root) {
		int sum =0;
		int finalSum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);

		while(!q.isEmpty()){
			TreeNode x = q.poll();

			if(x!= null){
				sum = sum+ x.data;
				if(x.left != null){
					q.offer(x.left);
				}
				if(x.right != null){
					q.offer(x.right);
				}

			}else{
				finalSum = sum;
				sum=0;
				if(!q.isEmpty()){
					q.offer(null);
				}

			}

		}

		return finalSum;

	}
}
