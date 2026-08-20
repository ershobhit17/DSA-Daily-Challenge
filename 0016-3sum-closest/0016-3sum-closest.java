import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two-pointer technique
        Arrays.sort(nums);
        
        // Initialize closest sum with first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Iterate through array, fixing one element at a time
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If current sum is exactly equal to target, return it
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Update closest sum if current sum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++; // Need larger sum, move left pointer right
                } else {
                    right--; // Need smaller sum, move right pointer left
                }
            }
        }
        
        return closestSum;
    }
}