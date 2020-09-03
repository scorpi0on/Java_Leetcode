package com.chen.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrder_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        //队列维持层节点的数据结构
        queue.offer(root);

        while (!queue.isEmpty()) {
            //获取队列大小
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            //目前该层node插入零时数组，然后获取其子Nodes加入多列
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                List<Node> children = curr.children;
                for (Node child : children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}
