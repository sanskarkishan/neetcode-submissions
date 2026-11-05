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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Notebook me try karo add krne.
        // r to l jane ka koi jarurat nhi hai,
        // Ek carry var chahiye.
        // last me agar carry bacha hua hai to carry ko ek new node me add krdo.
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val;
            temp += carry;
            carry = 0;
            if (temp > 9) {
                carry++;
                curr.next = new ListNode(temp % 10);
            } else {
                curr.next = new ListNode(temp % 10);
            }
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int temp = l1.val;
            temp += carry;
            carry = 0;
            if (temp > 9) {
                carry++;
                curr.next = new ListNode(temp % 10);
            } else {
                curr.next = new ListNode(temp % 10);
            }
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            int temp = l2.val;
            temp += carry;
            carry = 0;
            if (temp > 9) {
                carry++;
                curr.next = new ListNode(temp % 10);
            } else {
                curr.next = new ListNode(temp % 10);
            }
            l2 = l2.next;
            curr = curr.next;
        }
        if (carry == 1){
            carry = 0;
            curr.next = new ListNode(1);
        }
        return ans.next;
    }
}
