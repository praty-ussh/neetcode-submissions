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

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode temp = new ListNode();
        temp.val = head.val;
        while(head.next != null){
            temp = addFirst(head.next.val, temp);
            head = head.next;
        }
        return temp;
    }

    public ListNode addFirst(int data, ListNode temp){
        ListNode curr = new ListNode(data);
        curr.next = temp;
        return curr;
    }
}
