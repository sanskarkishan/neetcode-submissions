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
         * Optimal Approach (Two-Pointer Technique):
         * 1. Create a dummy node and point it to the head of the list.
         *    This helps handle edge cases such as removing the first node.
         * 2. Initialize two pointers, slow and fast, at the dummy node.
         * 3. Move the fast pointer n steps ahead.
         *    This creates a gap of n nodes between slow and fast.
         * 4. Move both pointers one step at a time until fast reaches
         *    the last node of the list.
         * 5. At this point, slow will be positioned just before the
         *    node that needs to be removed.
         * 6. Remove the target node by updating the next pointer:
         *       slow.next = slow.next.next;
         * 7. Return dummy.next as the new head of the modified list.
         *
         * Example:
         * Input : head = [1,2,3,4,5], n = 2
         * Fast moves 2 steps ahead.
         * Move both pointers until fast reaches the end.
         * Slow stops at node 3.
         * Remove node 4.
         * Output: [1,2,3,5]
         *
         * Time Complexity : O(n)
         * Space Complexity: O(1)
         */
        
        ListNode curr = new ListNode(-1);
        curr.next = head;
        ListNode slow = curr;
        ListNode fast = curr;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return curr.next;
    }
}
