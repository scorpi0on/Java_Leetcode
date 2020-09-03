package com.chen.Tree;

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

import java.util.ArrayList;
import java.util.List;

public class PostOrder_590 {
    public static List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        search(ans, root);
        return ans;
    }
    public static void search(List<Integer> ans, Node root){
        if(root == null){return;}

        for(var node : root.children){
            search(ans, node);
        }
        ans.add(root.val);
    }
}
