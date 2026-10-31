class Solution {
    public int search(int[] nums, int target) {
        // Intuition:
        // In a rotated sorted array, at least one half (left or right) is always sorted.
        // Find the middle element and check if it is the target.
        // If the left half is sorted, check whether the target lies within that range.
        // If yes, move to the left half; otherwise, search in the right half.
        // If the right half is sorted, check whether the target lies within that range.
        // If yes, move to the right half; otherwise, search in the left half.
        // Repeat until the target is found or the search space becomes empty.
        
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted
            if (nums[l] <= nums[mid]) {

                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            }
            // Right half sorted
            else {

                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            }
        }

        return -1;
    }
}
