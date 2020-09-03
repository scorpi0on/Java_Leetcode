package com.chen.Tree;

import java.util.ArrayList;
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

public class InOrderTraversal_94 {
        public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            search(ans, root);
            return ans;
        }

        public static void search(List<Integer> ans, TreeNode root){
            if (root == null){
                return;
            }

            if (root.left != null){
                search(ans, root.left);
            }

            ans.add(root.val);

            if (root.right != null){
                search(ans, root.right);
            }
    }

    public static List<Integer> inorderTraversalIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp =  stack.pop();
            result.add(temp.val);
            if (temp.right != null){
                curr = temp.right;
            }
        }

        return result;
    }

}
