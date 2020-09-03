package com.chen.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal_144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        search(ans, root);
        return ans;
    }

    public static void search(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);

        if (root.left != null) {
            search(ans, root.left);
        }

        if (root.right != null) {
            search(ans, root.right);
        }
    }

    public static List<Integer> preorderTraversalIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        if (root == null) {
            return result;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        left.right = new TreeNode(2);
        root.left = left;

        List<Integer> ans =  PreOrderTraversal_144.preorderTraversalIteration(root);
        Iterator<Integer> integerIterator = ans.iterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }
}
