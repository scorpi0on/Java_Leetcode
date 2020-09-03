package com.chen.Tree;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class PreOrder_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        // 前序遍历 - 使用栈实现
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        // 开始遍历所有节点
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            // 从后往前遍历其子节点，然后依次入栈
            if (node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.add(node.children.get(i));
                }

                // 官方更优遍历children方法
                // Collections.reverse(node.children);
                // for (Node childNode : node.children) {
                //     stack.add(childNode);
                // }
            }
        }

        return list;

    }

}

