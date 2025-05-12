/**
 * 递归
 * 时间复杂度：NlogN
 *
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

public class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if(left > right){
            return null;
        }
        if(left == right) {
            return lists[left];
        }
        
        int mid = left + (right - left)/2;
        
        ListNode leftList = mergeSort(lists, left ,mid);
        ListNode rightList = mergeSort(lists, mid + 1 ,right);
        
        //合并
        ListNode newhead = new ListNode();
        ListNode prev = newhead;
        
        while(leftList != null && rightList != null){
            if(leftList.val <= rightList.val) {
                prev.next = leftList;
                prev = leftList;
                leftList = leftList.next;
            } else {
                prev.next = rightList;
                prev = rightList;
                rightList = rightList.next;
            }
        }
        if(leftList != null){
           prev.next = leftList;
        }
        if(rightList != null){
           prev.next = rightList;
        }
        return newhead.next;
    }
}