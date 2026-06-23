package tree.binarytree.views;

import tree.binarytree.TreeNode;

public class FindCountOfSingleValuedSubTree
{
    int []count = {0};
    public int countSingle(TreeNode root){
        countSingleRec(root, count);
        return count[0];
    }

    public boolean countSingleRec(TreeNode root, int[] count){

        if(root == null) return true;

        boolean left = countSingleRec(root.left, count);
        boolean right = countSingleRec(root.right, count);

        if(left == false || right == false) return false;

        if(root.left != null && root.data != root.left.data) return false;

        if(root.right != null && root.data != root.right.data) return false;

        count[0]++;
        return true;
    }

    public static void main(String arg[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);


        FindCountOfSingleValuedSubTree f = new FindCountOfSingleValuedSubTree();

        System.out.println(f.countSingle(root));
    }

}
