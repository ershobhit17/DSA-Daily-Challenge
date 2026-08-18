import java.util.*;

public class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> freqOfFreq = new HashMap<>();
            
            for (int j = i; j < n; j++) {
                int val = nums[j];
                
                // Update frequency
                int oldFreq = freq.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;
                freq.put(val, newFreq);
                
                // Update freqOfFreq
                if (oldFreq > 0) {
                    int count = freqOfFreq.get(oldFreq) - 1;
                    if (count == 0) {
                        freqOfFreq.remove(oldFreq);
                    } else {
                        freqOfFreq.put(oldFreq, count);
                    }
                }
                freqOfFreq.put(newFreq, freqOfFreq.getOrDefault(newFreq, 0) + 1);
                
                // Check if balanced
                if (isBalanced(freqOfFreq, freq.size())) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }
    
    private boolean isBalanced(Map<Integer, Integer> freqOfFreq, int distinctCount) {
        // Only one distinct value
        if (distinctCount == 1) {
            return true;
        }
        
        // All frequencies are same
        if (freqOfFreq.size() == 1) {
            return false; // Need both f and 2f to exist
        }
        
        // Exactly two frequencies
        if (freqOfFreq.size() == 2) {
            int[] keys = new int[2];
            int idx = 0;
            for (int key : freqOfFreq.keySet()) {
                keys[idx++] = key;
            }
            
            int f1 = Math.min(keys[0], keys[1]);
            int f2 = Math.max(keys[0], keys[1]);
            
            // Check if one is double the other
            return (f2 == 2 * f1);
        }
        
        return false;
    }
}