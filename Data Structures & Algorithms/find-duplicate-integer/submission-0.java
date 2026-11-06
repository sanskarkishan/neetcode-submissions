class Solution {
    public int findDuplicate(int[] nums) {

/*
 * Problem: Find the Duplicate Number (LeetCode 287)
 *
 * Approach: Floyd's Cycle Detection (Tortoise and Hare)
 *
 * Logic:
 * 1. Treat the array as a linked list where:
 *      index -> node
 *      nums[index] -> next node
 *
 * 2. Since one number is duplicated, multiple indices point to the same
 *    value, creating a cycle in the linked list.
 *
 * 3. Use two pointers:
 *      slow moves one step at a time.
 *      fast moves two steps at a time.
 *
 * 4. The pointers will eventually meet inside the cycle.
 *
 * 5. Reset slow to index 0 and move both pointers one step at a time.
 *
 * 6. The point where they meet again is the duplicate number
 *    (the entrance of the cycle).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break;
        }
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
