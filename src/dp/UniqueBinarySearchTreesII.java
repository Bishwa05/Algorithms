package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode
 * 95. Unique Binary Search Trees II
 *
 * This is a classic DP problem. To get a sense of the thought process that would help you arrive at that conclusion, read on:
 * The key to this problem is the fundamental structural property of BSTs that all the nodes to the left of the root are smaller than it, and all on the right are greater, the property being true recursively.
 * Therefore, if the root if the integer i, then the keys on the left must include all the natural numbers upto i-1, and those on the right must contain the integers from i to the integer n.
 * But if you look closely, the keys on the right are only a version of the set {0,1,….,k}, for some k, wherein each value is incremented by a certain constant. So, getting the BSTs for the right and the left part of the root will have pretty much the same approach.
 * And if you have the BSTs for the left and the right part, then it takes only some assembling to get the BST with the key i as the root. Well, you have just solved the problem by breaking it down into it’s optimal sub-structures.
 * So now you make a new function which takes two integers as input, i.e., the beginning and the end, to give all the possible BSTs with the keys in the desired range, and then change the key in the root, to start the process over again.
 * At this point, it becomes nigh-on impossible to miss the fact that you will be repeating some computations that you have done in earlier iterations, for eg:image
 *
 * Therefore, you do see the overlapping sub-problems. So to optimize the process, all you need is some sort of a dump where you store the values as you compute them.
 *
 * So once you have a vague idea of how the problem is structured, it is easy to solve it.
 * You iterate over the numbers {0,1,..........,n} and in each iteration the integer i is put into the root, so create a node newroot and set the value as i.
 * Naturally, the numbers 0 to i-1 would go into the left sub-tree and i+1 to n go to the right.
 * Now, get all the possible BSTs for these two subtrees recursively and put then in All_left_BST and All_right_BST respectively.
 * Then, for every pair (left, right), where left belongs to All_left_BST and right belongs to All_right_BST, set the left child of newroot as left and
 * the right child as right, and put them into the result collection. Now, go over to the next iteration. Note that since for want to do this for all pairs of (left,right),
 * the loop would run |All_left_BST|x|All_right_BST| times. Of course, you can run it in a nested for loop where the first one runs over all the trees in All_left_BST and
 * the nested one over all in All_right_BST.
 *
 *
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);

    }

    public List<TreeNode> generateTrees(int start, int end) {
        System.out.println("start : "+start+ "end : "+end);
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
        int n =2;
        UniqueBinarySearchTreesII u = new  UniqueBinarySearchTreesII();
        u.generateTrees(n).forEach(e-> System.out.println(e));
    }
}
