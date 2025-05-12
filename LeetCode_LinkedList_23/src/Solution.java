/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 * 暴力解法
 * 时间复杂度：Nklogn
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
    ListNode newHead;
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        newHead = new ListNode();
        newHead.next = lists[0];
        for(int i = 0; i < lists.length; i++) {
            mySort(lists[i]);
        }
        return newHead.next;
    }
     
     private void mySort(ListNode list) {
        ListNode cur1 = list;
        ListNode cur2 = newHead.next;
        ListNode prev = newHead;
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val){
                prev.next = cur1;
                cur1 = cur1.next;
                prev.next.next = cur2;
                
                //移动指针
                prev = prev.next;
                
            } else {
                prev = cur2;
                cur2 = cur2.next;
//                cur2 = cur2.next;
//                prev.next.next = cur1;
//                ListNode next = cur1.next;
//                cur1.next = cur2;
//                prev = cur1;
//                cur1 = next;
            }
        }
        if(cur2 == null && cur1 != null) {
            prev.next = cur1;
        }
     }
 }