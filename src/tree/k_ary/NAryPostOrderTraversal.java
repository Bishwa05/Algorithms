package tree.k_ary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 *
 * https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/926/
 */
public class NAryPostOrderTraversal
{
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        dfs(root.children, res);
        res.add(root.val);
        return res;
    }

    public void dfs(List<Node> children, List<Integer> res){
        if(children == null) return;
        for(Node child: children){
            dfs(child.children, res);
            res.add(child.val);
        }
    }
}
