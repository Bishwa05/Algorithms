package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *                      10
 *               8              6
 *          3          5    9       4
 */

public class PathSumFromRoot {

    public boolean hasSumPath(BinaryTreeNode node, int sum)  {
        boolean ans =false;
        if(node == null)
            return sum == 0;
        else {
            int subSum = sum - node.data;

            if(subSum ==0 && node.left == null && node.right == null) {
                return true;
            }

            if(node.left != null) {
                ans = ans || hasSumPath(node.left, subSum);
            }
            if(node.right != null) {
                ans = ans || hasSumPath(node.right, subSum);
            }
        return ans;
        }
    }


    public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSumHelper(root, sum, res, temp);
        return res;
    }

    public void pathSumHelper(BinaryTreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if(root == null){
            return;
        } else {
            int subSum = sum - root.data;
            temp.add(root.data);

            if(subSum ==0 && root.left == null && root.right == null){
                res.add(temp);
                //temp = new ArrayList();
                return;
            }

            pathSumHelper(root.left, subSum, res, new ArrayList(temp));
            pathSumHelper(root.right, subSum, res, new ArrayList(temp));

        }
    }
    // Fails in test cases
//    public int findMaxSumPathRec(BinaryTreeNode root){
//
//
//        if(root == null) return 0;
//
//        int left = findMaxSumPathRec(root.left);
//
//        int right =
//            findMaxSumPathRec(root.right);
//
//        return root.data + ((left > right) ?
//            left : right);
//    }

    public boolean populatePath(BinaryTreeNode root, int sum, List<Integer> res){

        if(sum ==0 ) return true;

        if(root == null) return false;

        boolean left = populatePath(root.left, sum -root.data, res);
        boolean right = populatePath(root.right, sum - root.data, res);

        if(left || right){
            res.add(root.data);
        }
        return left || right;


    }

    public List<Integer> findMaxSumPath(BinaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
//        int sum = findMaxSumPathRec(root);
//        populatePath(root, sum, res);
        return res;
    }

    public int minRootToLeafSum(BinaryTreeNode root) {
        // Base case: if the tree is empty, return a large value since we are finding the minimum sum
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Base case: if we reached a leaf node, return its value
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftSum = minRootToLeafSum(root.left);
        int rightSum = minRootToLeafSum(root.right);

        return root.data + Math.min(leftSum, rightSum);
    }

    //-----------Another way for path max Sum -----------------------

    private static int globalMaximumSum;

    public int findMaximumPathSum(BinaryTreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }

    private static int findMaximumPathSumRecursive(BinaryTreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
        int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

        // ignore paths with negative sums, since we need to find the maximum sum we should
        // ignore any path which has an overall negative sum.
        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        // maximum path sum at the current node will be equal to the sum from the left
        // subtree + the sum from right subtree + val of current node
        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.data;

        // update the global maximum sum
        globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

        // maximum sum of any path from the current node will be equal to the maximum of
        // the sums from left or right subtrees plus the value of the current node
        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.data;
    }



    //---------------------------------------------------------------

    public static void main(String arg[]) {

        int sum = 25; //10+6+7

        BinaryTreeNode root = generateTree();
        PathSumFromRoot p = new PathSumFromRoot();
        //System.out.println(p.hasSumPath(root, sum));

//        List<List<Integer>> res = p.pathSum(root, sum);
//
//        res.forEach(e -> e.forEach( e1 -> System.out.println(e1)));

        p.findMaxSumPath(root).forEach(e -> System.out.println(e));

    }

    public static BinaryTreeNode generateTree() {

        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode left = new BinaryTreeNode(8);
        BinaryTreeNode right11 = new BinaryTreeNode(3);
        BinaryTreeNode left11 = new BinaryTreeNode(5);
        BinaryTreeNode right = new BinaryTreeNode(6);
        BinaryTreeNode left21 = new BinaryTreeNode(9);
        BinaryTreeNode right21 = new BinaryTreeNode(4);

        left.left = left11;
        left.right = right11;
        right.left =left21;
        right.right = right21;
        root.left = left;
        root.right = right;

        return root;
    }
}
