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
    public void reorderList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        ListNode ans = head;
        int n = list.size();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            ans.next = new ListNode(list.get(i));
            ans = ans.next;
            ans.next = new ListNode(list.get(j));
            ans = ans.next;
            i++;
            j--;
        }
        if (n % 2 == 1) {
            ans.next = new ListNode(list.get(i));
        }
        head.next = head.next.next;
    }
}
