class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Intuition:
        // We need the maximum element for every window of size k.
        // Instead of finding the maximum again and again for each window,
        // maintain a deque that stores indices in decreasing order of their values.
        //
        // 1. Remove indices from the front that are outside the current window.
        // 2. While adding a new element, remove all smaller elements from the back
        //    because they can never become the maximum as the current element is larger.
        // 3. Add the current index to the deque.
        // 4. The front of the deque always contains the index of the maximum element
        //    in the current window.
        // 5. Once the first window is formed (i >= k - 1), store the maximum.
        //
        // This way, every element is added and removed at most once,
        // resulting in O(n) time complexity.

        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);

            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
