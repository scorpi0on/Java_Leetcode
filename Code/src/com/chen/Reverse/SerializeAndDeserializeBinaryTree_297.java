package com.chen.Reverse;

import java.util.*;

public class SerializeAndDeserializeBinaryTree_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("null ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode no2 = new TreeNode(2);
        TreeNode no3 = new TreeNode(3);
        TreeNode no4 = new TreeNode(4);
        TreeNode no5 = new TreeNode(5);
        root.left = no2;
        root.right = no3;
        no3.left = no4;
        no3.right = no5;
        SerializeAndDeserializeBinaryTree_297 serializeAndDeserializeBinaryTree_297 = new SerializeAndDeserializeBinaryTree_297();
        String data = serializeAndDeserializeBinaryTree_297.serialize(root);
        System.out.println(data);
        System.out.println("--------");
        TreeNode ans = serializeAndDeserializeBinaryTree_297.deserialize(data);
        System.out.println(serializeAndDeserializeBinaryTree_297.serialize(ans));
    }
}
