class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0;
        int evenCount = 1; // Empty prefix sum (0 is even)
        int prefixSum = 0;
        int result = 0;
        
        for (int num : arr) {
            prefixSum += num;
            
            if (prefixSum % 2 == 0) {
                // Current prefix sum is even
                // Subarrays ending here with odd sum = oddCount
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                // Current prefix sum is odd
                // Subarrays ending here with odd sum = evenCount
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return result;
    }
}