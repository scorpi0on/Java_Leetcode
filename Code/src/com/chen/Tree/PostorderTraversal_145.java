package com.chen.Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class PostorderTraversal_145 {
    public static List<Integer> postorderTraversalIteration(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        if (root == null){
            return result;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            TreeNode curr = linkedList.pollLast();
            result.addFirst(curr.val);//每次在链表的头部插入元素
            if (curr.left != null) {  //注意与前序对比着看
                linkedList.add(curr.left);
            }
            if (curr.right != null) {
                linkedList.add(curr.right);
            }
        }return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;

        List<Integer> ans =  PostorderTraversal_145.postorderTraversalIteration(root);
        Iterator<Integer> integerIterator = ans.iterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }
}
