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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /*
     * Logic:
     * 1. Create a dummy node (result) to simplify insertion.
     * 2. Use ans pointer to build the merged list.
     * 3. Compare nodes from both lists.
     * 4. Insert the smaller value into the new list.
     * 5. Move the corresponding list pointer forward.
     * 6. Move ans forward after every insertion.
     * 7. When one list becomes empty, append remaining nodes of the other list.
     * 8. Return result.next because result is a dummy node.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * (Since new nodes are being created)
     */

        ListNode result = new ListNode(-1);
        ListNode ans = result;


        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ans.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                ans.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ans = ans.next;
        }

        while (list1 != null) {
            ans.next = new ListNode(list1.val);
            list1 = list1.next;
            ans = ans.next;
        }
        while (list2 != null) {
            ans.next = new ListNode(list2.val);
            list2 = list2.next;
            ans = ans.next;
        }

        return result.next;
    }
}