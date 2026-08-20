import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if array has less than 4 elements
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // Sort the array to use two-pointer technique
        Arrays.sort(nums);
        int n = nums.length;
        
        // Fix first element
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Optimization: if minimum possible sum > target, break
            long minSum1 = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minSum1 > target) {
                break;
            }
            
            // Optimization: if maximum possible sum < target, continue
            long maxSum1 = (long)nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxSum1 < target) {
                continue;
            }
            
            // Fix second element
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Optimization: if minimum possible sum > target, break
                long minSum2 = (long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minSum2 > target) {
                    break;
                }
                
                // Optimization: if maximum possible sum < target, continue
                long maxSum2 = (long)nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxSum2 < target) {
                    continue;
                }
                
                // Use two pointers for remaining two elements
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left pointer
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for right pointer
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}