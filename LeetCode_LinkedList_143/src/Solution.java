/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
     public void reorderList(ListNode head) {
         if(head == null || head.next == null ||head.next.next == null){
             return;
         }
         ListNode fast = head;
         ListNode slow = head;
         
         //快慢双指针找到中间节点
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next;
             fast = fast.next;
         }
         
         //翻转 slow 后面的节点（头插法）
         ListNode head2 = new ListNode(0);
         ListNode cur = slow.next;
         slow.next = null;
         while(cur != null) {
             ListNode next = cur.next;
             cur.next = head2.next;
             head2.next = cur;
             cur = next;
            
         }
         
         //拼接节点
         ListNode cur1 = head, cur2 = head2.next;
         ListNode ret = new ListNode(0);
         ListNode prev = ret;
         while(cur1 != null) {
            prev.next = cur1;
            prev = cur1;
            cur1 = cur1.next;
            
            if(cur2 != null){
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
         }
     }
}