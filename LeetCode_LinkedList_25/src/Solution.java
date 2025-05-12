/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
    }
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        
        //需要翻转的组数
        int frequency = count/k;
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        ListNode tmp = null;
        cur = head;
        
        
        for(int i = 0; i < frequency; i++)
        {
            tmp = cur;
            for(int j = 0; j < k; j++)
            {
                //头插的逻辑
                
                ListNode next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = next;
            }
            prev = tmp;
        }
        prev.next = cur;
        return newHead.next;
    }
}