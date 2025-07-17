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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                if(t.val > max) {
                    max = t.val;
                }
                if(t.left != null){
                    queue.add(t.left);
                }
                if(t.right != null){
                    queue.add(t.right);
                }
            }
            ret.add(max);
        }
        return ret;
    }
}