/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔
 *
 * 队列结合宽度搜索
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node t = queue.poll();
                tmp.add(t.val);
                for(Node child : t.children) {
                    if(child != null) {
                        queue.offer(child);
                    }
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}