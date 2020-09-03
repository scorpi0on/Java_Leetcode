package com.chen.Reverse;

public class LowestAommonAncestorOfaBinaryTree_236 {
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }

        boolean leftson = dfs(root.left,p,q);
        boolean rightson = dfs(root.left,p,q);

        if (leftson && rightson || ((root.val == p.val || root.val == q.val) && (leftson || rightson)) ){
            this.ans=root;
        }
        return leftson || rightson || (root.val == p.val || root.val == q.val);
    }
    public TreeNode  lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

}
