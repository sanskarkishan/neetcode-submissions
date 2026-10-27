class Solution {
    public int maxArea(int[] heights) {
        // h[i] < h[j] -> i++ else j--;
        int n = heights.length;
        int max = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(heights[i], heights[j]));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
