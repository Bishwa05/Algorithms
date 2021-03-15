package binarysearch;

/**
 * 222. Count Complete Tree Nodes
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 */
public class CountCompleteTreeNodes
{
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHeight = fullTreeHeight(root.left);
        int rightHeight = fullTreeHeight(root.right);

        if(leftHeight == rightHeight){
            return (1<< leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    public int fullTreeHeight(TreeNode root){
        if(root == null) return 0;
        int res =0;
        while(root != null){
            root = root.left;
            res++;
        }
        return res;
    }

    public static void main(String arg[]){
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        System.out.println(c.countNodes(t));
    }
}
