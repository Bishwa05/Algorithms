package tree.binarytree.crud;

import tree.binarytree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class SerializeDeserializeBinaryTree {

    // Helper method for serialization
    private void recserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.data).append(",");
        recserialize(root.left, sb);
        recserialize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recserialize(root, sb);
        return sb.toString();
    }

    // Helper method for deserialization
    private TreeNode recdeserialize(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }

        String first = list.remove(0);
        if (first.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(first));
        root.left = recdeserialize(list);
        root.right = recdeserialize(list);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        // Split by the exact same delimiter used in serialization
        String[] strArr = data.split(",");
        List<String> strList = new LinkedList<>(Arrays.asList(strArr));
        return recdeserialize(strList);
    }
}
