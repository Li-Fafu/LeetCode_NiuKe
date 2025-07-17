/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
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
    
    Long prev = Long.MIN_VALUE;
    boolean flag = true;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        
        boolean left = isValidBST(root.left);
        
        if (root.val <= prev) {
            flag = false;
        }
        
        if (!flag) {
            return flag;
        }
        
        prev = (long) root.val;
        
        if (!left) {
            return left;
        }
        
        boolean right = isValidBST(root.right);
        
        return left && right && flag;
    }
}