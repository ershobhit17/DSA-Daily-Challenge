class Solution {
    public boolean isStrictlyPalindromic(int n) {
        // Check for all bases from 2 to n-2
        for (int base = 2; base <= n - 2; base++) {
            String representation = convertToBase(n, base);
            if (!isPalindrome(representation)) {
                return false;
            }
        }
        return true;
    }
    
    private String convertToBase(int n, int base) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int remainder = n % base;
            result.insert(0, remainder);
            n /= base;
        }
        return result.toString();
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}