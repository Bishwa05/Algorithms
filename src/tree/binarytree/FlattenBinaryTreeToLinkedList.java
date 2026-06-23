package tree.binarytree;

import java.util.Stack;

/**
 * Leetcode
 * 114. Flatten Binary Tree to Linked List
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class FlattenBinaryTreeToLinkedList
{
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(p != null || !stack.empty()){

            if(p.right != null){
                stack.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }

            p = p.right;
        }
    }

    public static TreeNode generateTree() {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);

        TreeNode left11 = new TreeNode(3);
        TreeNode right11 = new TreeNode(4);

        TreeNode right21 = new TreeNode(6);

        left.left = left11;
        left.right = right11;
        right.right = right21;
        root.left = left;
        root.right = right;

        return root;
    }


    public static void main(String arg[]) {

        TreeNode root = generateTree();
        FlattenBinaryTreeToLinkedList p = new FlattenBinaryTreeToLinkedList();
        //System.out.println(p.hasSumPath(root, sum));

        p.flatten(root);

        System.out.println(root);


    }
}
