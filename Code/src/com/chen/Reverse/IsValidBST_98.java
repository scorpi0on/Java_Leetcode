package com.chen.Reverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IsValidBST_98 {
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static boolean isValidBSTIteration(TreeNode root){
        Stack<TreeNode>  stack = new Stack<>();

        double inorder = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = root2;
//        root2.left = new TreeNode(3);
//        root2.right = new TreeNode(6);
        System.out.println(IsValidBST_98.isValidBST(root));
    }
}
