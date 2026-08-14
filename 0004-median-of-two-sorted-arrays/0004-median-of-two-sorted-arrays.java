class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for binary search efficiency
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;
        
        int left = 0;
        int right = m;
        
        while (left <= right) {
            // Partition point in nums1
            int partition1 = (left + right) / 2;
            // Corresponding partition point in nums2
            int partition2 = half - partition1;
            
            // Handle edge cases where partition is at boundaries
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if (total % 2 == 1) {
                    return Math.min(minRight1, minRight2);
                } else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // Need to move partition1 left
                right = partition1 - 1;
            } else {
                // Need to move partition1 right
                left = partition1 + 1;
            }
        }
        
        // Should never reach here if inputs are valid
        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }
}