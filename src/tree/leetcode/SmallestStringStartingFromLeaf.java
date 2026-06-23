package tree.leetcode;

import tree.binarytree.TreeNode;

public class SmallestStringStartingFromLeaf
{
    String ans = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb){
        if(node == null) return;
        sb.append((char)('a'+ node.data));

        if(node.left == null && node.right == null){
            sb.reverse();
            String s = sb.toString();

            sb.reverse();

            if("".equals(ans) ||s.compareTo(ans)<0){
                ans = s;
            }
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
