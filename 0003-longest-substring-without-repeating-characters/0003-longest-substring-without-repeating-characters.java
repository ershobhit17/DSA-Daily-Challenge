import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        
        // Map to store the last occurrence index of each character
        Map<Character, Integer> lastIndex = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in window, move left pointer
            if (lastIndex.containsKey(currentChar)) {
                // Move left to one position after the last occurrence
                left = Math.max(left, lastIndex.get(currentChar) + 1);
            }
            
            // Update last occurrence of current character
            lastIndex.put(currentChar, right);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}