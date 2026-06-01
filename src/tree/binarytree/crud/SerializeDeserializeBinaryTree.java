package tree.binarytree.crud;

import tree.binarytree.BinaryTreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class SerializeDeserializeBinaryTree {
    public String recserialze(BinaryTreeNode root, String str) {
        if (root == null) {
            str += "null";
        } else {
            str += String.valueOf(root.data) + ",";
            str = recserialze(root.left, str);
            str = recserialze(root.right, str);
        }
        return str;
    }
    public String serialize(BinaryTreeNode root) {
        return recserialze(root, "");
    }

    public BinaryTreeNode recdeserialize(List<String> str) {
        if (str.get(0).equals("null")) {
            str.remove(0);
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(str.get(0)));
        str.remove(0);
        root.left = recdeserialize(str);
        root.right = recdeserialize(str);
        return root;
    }

    public BinaryTreeNode deserialize(String data) {
        String[] strArr = data.split(", ");
        List<String> strList = new LinkedList<>(Arrays.asList(strArr));
        return recdeserialize(strList);
    }
}
