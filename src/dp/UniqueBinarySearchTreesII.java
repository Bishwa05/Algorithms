package dp;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);

    }

    public List<TreeNode> generateTrees(int start, int end) {
       List<TreeNode> list = new ArrayList<>();
       if(start>end){
           list.add(null);
           return list;
       }

       List<TreeNode> left, right;

       for(int i= start; i<=end; i++){
           left = generateTrees(start, i-1);
           right = generateTrees(i+1, end);

           for(TreeNode lNode : left){
               for(TreeNode rNode:  right){
                   /* There exists a combination for each tree. */
                   TreeNode root = new TreeNode(i);
                   root.left = lNode;
                   root.right = rNode;
                   list.add(root);
               }
           }
       }
       return list;

    }

    public static void main(String arg[]) {
        int n =3;
        UniqueBinarySearchTreesII u = new  UniqueBinarySearchTreesII();
        u.generateTrees(n).forEach(e-> System.out.println(e));
    }
}
