/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
  }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode prev = head;
        
        ListNode cur1 = l1, cur2 = l2;
        
        int sum = 0;
        while(cur1 != null || cur2 != null || sum != 0) {
            if(cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            
            prev.next = new ListNode(sum%10);
            prev = prev.next;
            
            sum/=10;
        }
        
        return head.next;
    }
}