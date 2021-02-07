package Algorthm.LeetCode;

 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
/*
핵심 알고리즘 : linked list
고민거리 : iteration 과 recursive 모두 사용하여 풀이가 가능하다
          null 값을 갖고 있는 노드를 사용하여 역순 노드의 마지막이 되도록 지정하고
          순차적으로 순회하며 역순으로 배치한다.
 */

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