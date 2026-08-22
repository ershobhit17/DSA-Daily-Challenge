class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int evenIndex = 0;  // pointer for even positions (0, 2, 4, ...)
        int oddIndex = 1;   // pointer for odd positions (1, 3, 5, ...)
        
        while (evenIndex < n && oddIndex < n) {
            // Find an even number at an odd position
            while (evenIndex < n && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            
            // Find an odd number at an even position
            while (oddIndex < n && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            
            // Swap them if both found
            if (evenIndex < n && oddIndex < n) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }
        
        return nums;
    }
}