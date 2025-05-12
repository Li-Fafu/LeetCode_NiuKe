/**
 * 优先级队列
 * 时间复杂度：Nlogk
 */



//Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
     
        //创建优先级队列并传入比较规则
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1,v2) -> v1.val - v2.val);
        
        //把节点添加到队列当中
        for( ListNode x : lists) {
            if(x != null){
                heap.add(x);
            }
        }
        
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        
        while(!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            prev.next = tmp;
            prev = tmp;
            if(tmp.next != null) {
                heap.add(tmp.next);
            }
        }
        return newHead.next;
    }
}