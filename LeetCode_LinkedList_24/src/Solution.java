/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

//Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
 public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode nnext = next.next;
        while(cur != null && next != null) {
            //交换节点
            prev.next = next;
            next.next = cur;
            cur.next = nnext;
            
            //移动指针，注意边界
            prev =cur;
            cur = nnext;
            if(cur != null){
                next = cur.next;
            }
            if(next != null){
                nnext = next.next;
            }
        }
        return newHead.next;
    }
}