class Solution {
    public int countValidWords(String sentence) {
        // Split by one or more spaces
        String[] tokens = sentence.trim().split("\\s+");
        int validCount = 0;
        
        for (String token : tokens) {
            if (isValidWord(token)) {
                validCount++;
            }
        }
        
        return validCount;
    }
    
    private boolean isValidWord(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        
        int hyphenCount = 0;
        int punctuationCount = 0;
        int punctuationIndex = -1;
        int hyphenIndex = -1;
        
        for (int i = 0; i < token.length(); i++) {
            char ch = token.charAt(i);
            
            // Check for digits
            if (Character.isDigit(ch)) {
                return false;
            }
            
            // Count hyphens
            if (ch == '-') {
                hyphenCount++;
                hyphenIndex = i;
                if (hyphenCount > 1) {
                    return false; // More than one hyphen
                }
            }
            
            // Count punctuation marks
            if (ch == '!' || ch == '.' || ch == ',') {
                punctuationCount++;
                punctuationIndex = i;
                if (punctuationCount > 1) {
                    return false; // More than one punctuation
                }
            }
            
            // Check for uppercase letters (optional, but problem says lowercase only)
            if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        
        // Validate hyphen placement (if present)
        if (hyphenCount == 1) {
            // Hyphen must be surrounded by lowercase letters
            if (hyphenIndex == 0 || hyphenIndex == token.length() - 1) {
                return false; // Hyphen at start or end
            }
            
            char prevChar = token.charAt(hyphenIndex - 1);
            char nextChar = token.charAt(hyphenIndex + 1);
            
            if (!Character.isLowerCase(prevChar) || !Character.isLowerCase(nextChar)) {
                return false; // Not surrounded by letters
            }
        }
        
        // Validate punctuation placement (if present)
        if (punctuationCount == 1) {
            // Punctuation must be at the end
            if (punctuationIndex != token.length() - 1) {
                return false; // Punctuation not at end
            }
        }
        
        return true;
    }
}