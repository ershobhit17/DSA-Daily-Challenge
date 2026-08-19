class Solution {
    public int myAtoi(String s) {
        // Constants for 32-bit signed integer range
        final int INT_MAX = Integer.MAX_VALUE;   // 2147483647
        final int INT_MIN = Integer.MIN_VALUE;   // -2147483648
        
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If we've reached the end, return 0
        if (i >= n) {
            return 0;
        }
        
        // Step 2: Determine sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        // Step 3: Read digits and build the number
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // Convert char to int
            
            // Check for overflow before adding the digit
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        // Apply sign and return
        return sign * result;
    }
}