import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Map digits to their corresponding letters
        String[] phoneMap = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        // Start backtracking
        backtrack(result, phoneMap, digits, new StringBuilder(), 0);
        
        return result;
    }
    
    private void backtrack(List<String> result, String[] phoneMap, String digits, 
                           StringBuilder current, int index) {
        // Base case: if we've processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters for the current digit
        String letters = phoneMap[digits.charAt(index) - '0'];
        
        // Try each letter for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Choose
            backtrack(result, phoneMap, digits, current, index + 1); // Explore
            current.deleteCharAt(current.length() - 1); // Un-choose (backtrack)
        }
    }
}