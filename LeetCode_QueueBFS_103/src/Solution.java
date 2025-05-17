/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */

import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < sz; i++) {
                TreeNode t = queue.poll();
                tmp.add(t.val);
                if(t.left != null) {
                    queue.add(t.left);
                }
                if(t.right != null) {
                    queue.add(t.right);
                }
            }
            if(count++%2 == 1) {
                Collections.reverse(tmp);
            }
            ret.add(tmp);
        }
        return ret;
    }
}
