class Solution {
    public int findMin(int[] nums) {
        // In a rotated sorted array, one side is always sorted.
        // Intuition:
        // Compare nums[mid] with nums[r] to determine where the minimum lies.
        //
        // Case 1: nums[mid] > nums[r]
        //         Minimum must be in the right half.
        //         Move left pointer to mid + 1.
        //
        // Case 2: nums[mid] <= nums[r]
        //         Right half is sorted and the minimum could be at mid.
        //         Keep mid in the search space by setting r = mid.
        //
        // Continue shrinking the search space until l == r.
        // At that point, both pointers point to the minimum element.
        
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
