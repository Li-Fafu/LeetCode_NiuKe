/**
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 */
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if(root.left == null && root.right == null && root.val == 0){
            root = null;
        }
        return root;
    }
}