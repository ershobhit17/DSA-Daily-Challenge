class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        int n = s.length();
        int start = 0;
        int end = 0;
        
        for (int center = 0; center < n; center++) {
            // Expand for odd length
            int left = center;
            int right = center;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // Update if found longer palindrome
            if (right - left - 1 > end - start + 1) {
                start = left + 1;
                end = right - 1;
            }
            
            // Expand for even length
            left = center;
            right = center + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > end - start + 1) {
                start = left + 1;
                end = right - 1;
            }
        }
        
        return s.substring(start, end + 1);
    }
}