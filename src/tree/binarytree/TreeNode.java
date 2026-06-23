package tree.binarytree;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.data = val;
		this.left = null;
		this.right = null;
	}

    TreeNode() {

    }

	TreeNode(int val, TreeNode left, TreeNode right) {
          this.data = val;
          this.left = left;
          this.right = right;
	}
//	public int getVal() {
//		return data;
//	}
//
//	public void setVal(int data) {
//		this.data = data;
//	}
//
//	public BinaryTreeNode getLeft() {
//		return left;
//	}
//
//	public void setLeft(BinaryTreeNode left) {
//		this.left = left;
//	}
//
//	public BinaryTreeNode getRight() {
//		return right;
//	}
//
//	public void setRight(BinaryTreeNode right) {
//		this.right = right;
//	}

}
