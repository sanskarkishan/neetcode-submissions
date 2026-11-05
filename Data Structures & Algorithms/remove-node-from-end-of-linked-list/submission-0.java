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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        /*
         * Problem:
         * Remove the Nth node from the end of a singly linked list and return the updated head.
         *
         * Approach:
         * 1. Traverse the linked list and calculate its total length (l).
         * 2. If n == l, the node to be removed is the head node,
         *    so return head.next.
         * 3. Otherwise, move to the node just before the target node.
         *    The target node is at position (l - n + 1) from the start,
         *    so stop at position (l - n).
         * 4. Remove the target node by updating the next pointer:
         *       temp.next = temp.next.next;
         * 5. Return the modified head.
         *
         * Example:
         * Input : head = [1,2,3,4,5], n = 2
         * Length: 5
         * Node to remove: 4
         * Output: [1,2,3,5]
         *
         * Time Complexity : O(n)
         * Space Complexity: O(1)
         */
        
        ListNode curr = head;
        int l = 0;
        while (curr != null) {
            l++;
            curr = curr.next;
        }
        if (n == l) {
            return head.next;
        } else {
            ListNode temp = head;
            for (int i = 0; i < l - n - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}
