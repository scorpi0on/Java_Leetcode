package com.chen.Reverse;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if(root.left == null || root.right == null) return m1 + m2 + 1;

        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }

    public class QueueNode{
        public TreeNode root;
        public int depth;
        public QueueNode(TreeNode root, int depth){
            this.depth = depth;
            this.root =  root;
        }
    }

    public int minDepthIteration(TreeNode root) {
        if(root == null) return 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root,1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode curr = queueNode.root;
            int depth = queueNode.depth;
            if (curr.left == null && curr.right == null) {
                return depth;
            }
            if (curr.left != null) {
                queue.offer(new QueueNode(curr.left, depth + 1));
            }
            if (curr.right != null) {
                queue.offer(new QueueNode(curr.right, depth + 1));
            }
        }
        return 0;
    }

}
