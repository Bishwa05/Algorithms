package binarysearch;

import java.util.LinkedList;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInABST
{
    int count =0;
    int res=0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;

    }

    public void dfs(TreeNode root) {
        if(root.left != null){
            dfs(root.left);
        }
        count --;
        if(count ==0) {
            res = root.val;
            return;
        }

        if(root.right != null){
            dfs(root.right);
        }
    }

    /**
     * Iterative
     */
    public int kthSmallestItr(TreeNode root, int k) {
        // count = k;
        // dfs(root);
        // return res;

        LinkedList<TreeNode> q = new LinkedList<>();


        while(!q.isEmpty() || root != null){
            if(root != null){
                q.add(root);
                root = root.left;
            } else{
                root = q.removeLast();
                k--;
                if(k ==0) return root.val;

                root = root.right;
            }
        }
        return -1;
    }
}
