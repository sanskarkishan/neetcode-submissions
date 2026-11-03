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
       ListNode newNode = null;
        ListNode curr = head;
        while (curr != null) {
            int val = curr.val;
            ListNode temp = new ListNode(val);
            temp.next = newNode;
            newNode = temp;
            curr = curr.next;
        }
        return newNode;
    }
}
