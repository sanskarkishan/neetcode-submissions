class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] temp = new int[n + m];
        int i = 0, j = 0, idx = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                temp[idx++] = nums1[i++];
            } else {
                temp[idx++] = nums2[j++];
            }
        }

        while (i < n) {
            temp[idx++] = nums1[i++];
        }

        while (j < m) {
            temp[idx++] = nums2[j++];
        }

        int size = temp.length;
        if (size % 2 == 1) {
            return temp[size / 2];
        } else {

            return (temp[size / 2] + temp[size / 2 - 1]) / 2.0;
        }
    }
}
