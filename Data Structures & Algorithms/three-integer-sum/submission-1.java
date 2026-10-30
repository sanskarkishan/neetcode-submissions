class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         * Approach:
         * 1. Sort the array.
         * 2. Fix one element at index i. Also check for dublicate, if forund continue.
         * 3. Use two pointers (l, r) to find two numbers such that
         *    nums[i] + nums[l] + nums[r] = 0.
         * 4. If sum < 0, move left pointer right.
         * 5. If sum > 0, move right pointer left.
         * 6. If sum == 0, store the triplet and skip duplicates.
         * 7. Repeat for all elements.
         *
         * Time Complexity: O(n²)
         * Space Complexity: O(1) (excluding output list)
         */
        
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); // Sort array for two-pointer approach

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1; // Left pointer
            int r = n - 1; // Right pointer

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0) {
                    l++; // Need a larger sum
                }
                else if (sum > 0) {
                    r--; // Need a smaller sum
                }
                else {

                    // Found a valid triplet
                    list.add(List.of(nums[i], nums[l], nums[r]));

                    // Skip duplicate left values
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    // Skip duplicate right values
                    // while (l < r && nums[r] == nums[r - 1]) {
                    //     r--;
                    // }

                    l++;
                    r--;
                }
            }
        }

        return list;
    }
}
