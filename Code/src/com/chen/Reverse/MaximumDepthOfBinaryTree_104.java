package com.chen.Reverse;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_104 {
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return  1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }
//    广度优先搜索
    public static int maxDepthBFS(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer((temp.left));
                }
                if (temp.right != null) {
                    queue.offer((temp.right));
                }
                size --;
            }
            ans++;
        }
            return ans ;
    }
}
