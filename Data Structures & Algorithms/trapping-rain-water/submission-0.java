class Solution {
    public int trap(int[] height) {
        /*
         * Approach:
         * 1. Use two pointers (l, r) starting from both ends.
         * 2. Maintain leftMax and rightMax as the highest bars seen so far.
         * 3. If height[l] < height[r]:
         *      - Update leftMax.
         *      - Water trapped at l = leftMax - height[l].
         *      - Move l forward.
         * 4. Otherwise:
         *      - Update rightMax.
         *      - Water trapped at r = rightMax - height[r].
         *      - Move r backward.
         * 5. Continue until l meets r.
         * 6. Return total trapped water.
         *
         * Time Complexity: O Space Complexity: O(1)
         */

        int n = height.length;
        int lMax = 0;
        int rMax = 0;
        int water = 0;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
                r--;
            }
        }
        return water;
    }
}
