package Algorthm.LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//역방향 연결리스트와 input 연결 리스트가 같다면 true
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head ==null) return true;

        ListNode pre = new ListNode(head.val);
        ListNode now = head;

        while(now.next != null){
            ListNode temp = new ListNode(now.next.val);
            temp.next = pre;
            pre = temp;
            now = now.next;
        }

        ListNode p1 = pre;
        ListNode p2 = head;
        while( p1 !=null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;

        }
        return true;
    }
}