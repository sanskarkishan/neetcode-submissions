class Solution {
    public int largestRectangleArea(int[] heights) {
        // Find all the left and right smallest element of all the heights, and store in 2 diff arr.
        // Then we have to calculate the area of a window for height[i]
        // currArea = height[i] * (r[i] - l[i] - 1)
        // and update the result = max(currArea, result);

        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] rightSmallest = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            rightSmallest[i] = st.isEmpty() ? n : st.peek(); // n bcz if we did not get any smaller element then it set n for the window.
            st.push(i);
        }

        st.clear();
        int[] leftSmallest = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            leftSmallest[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int area = 0;

        for (int i = 0; i < n; i++) {
            int currArea = heights[i] * (rightSmallest[i] - leftSmallest[i] -1);
            area = Math.max(area, currArea);
        }
        return area;
    }
}
