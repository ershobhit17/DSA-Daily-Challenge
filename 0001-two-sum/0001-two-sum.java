class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                // Return the indices
                return new int[]{map.get(complement), i};
            }
            
            // Store current number with its index
            map.put(nums[i], i);
        }
        
        // According to problem, we'll always find a solution
        return new int[]{};
    }
}