import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，
 * 两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
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

public  class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Pair<TreeNode, Integer>> queue = new ArrayList<>();
        queue.add(new Pair<>(root, 1));
        int ret = 0;
        
        while(!queue.isEmpty()) {
            ret = Math.max(ret, (queue.get(queue.size()-1).getValue() - queue.get(0).getValue() + 1));
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for(Pair<TreeNode, Integer> t : queue) {
                TreeNode node = t.getKey();
                int index = t.getValue();
                if(node.left != null){
                    tmp.add(new Pair<TreeNode,Integer>(node.left, index * 2));
                }
                if(node.right != null){
                    tmp.add(new Pair<TreeNode,Integer>(node.right, index * 2 + 1));
                }
                
            }
            queue = tmp;
        }
        return  ret;
    }
}