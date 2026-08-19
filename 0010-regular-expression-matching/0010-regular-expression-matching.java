class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] = true if first i chars of s match first j chars of p
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (pChar == '*') {
                    // '*' matches zero or more of the preceding element
                    char prevChar = p.charAt(j - 2);
                    
                    // Case 1: Match zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Match one or more occurrences of the preceding character
                    if (prevChar == '.' || prevChar == sChar) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Regular character or '.'
                    if (pChar == '.' || pChar == sChar) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}