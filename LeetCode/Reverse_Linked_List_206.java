package Algorthm.LeetCode;

 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


// iteration 풀이
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode now = head;
        while(now != null){
            ListNode temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
        }
        return prev;
    }
}

//recursive 풀이
class Solution {
    public ListNode reverseList(ListNode head) {
        return recursiveList(head, null);
    }

    private ListNode recursiveList(ListNode head, ListNode newHead){
        if(head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return recursiveList(next, head);
    }
}