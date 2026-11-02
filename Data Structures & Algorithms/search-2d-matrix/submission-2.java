class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Since the first element of every row is greater than
        // the last element of the previous row, the entire matrix
        // behaves like a sorted 1D array.
        //
        // We perform Binary Search on indices from
        // 0 to rows * cols - 1.
        //
        // For any mid index:
        // row = mid / cols
        // col = mid % cols
        //
        // This lets us access the corresponding matrix element
        // without creating a new array.
        //
        // Time Complexity: O(log(m * n))
        // Space Complexity: O(1)        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
