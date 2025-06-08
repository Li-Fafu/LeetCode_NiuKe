/**
 *
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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    
    private int dfs(TreeNode root, int presum) {
        presum = presum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return presum;
        }
        
        int ret = 0;
        if(root.left != null) {
            ret += dfs(root.left, presum);
        }
        if(root.right != null) {
            ret += dfs(root.right, presum);
        }
        return ret;
    }
}