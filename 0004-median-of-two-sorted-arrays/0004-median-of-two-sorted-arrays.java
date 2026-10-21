
        class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        
        // Dono sorted arrays ko merge kar lo
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        // Median nikal lo
        int totalLen = m + n;
        if (totalLen % 2 == 1) {
            return (double) merged[totalLen / 2];
        } else {
            int mid1 = merged[totalLen / 2 - 1];
            int mid2 = merged[totalLen / 2];
            return (double) (mid1 + mid2) / 2.0;
        }
    }
}
        
 