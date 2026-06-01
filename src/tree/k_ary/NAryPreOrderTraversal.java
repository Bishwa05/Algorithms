package tree.k_ary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/925/
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 *
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NAryPreOrderTraversal
{
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        list.add(root.val);
        dfs(root.children, list);
        return list;

    }

    public void dfs(List<Node> childrens, List<Integer> list){
        if(childrens != null){
            for(Node child : childrens){
                list.add(child.val);
                dfs(child.children, list);

            }
        }
    }
}
