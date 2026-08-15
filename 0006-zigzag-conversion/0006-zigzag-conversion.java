class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = true;
        
        // Traverse the string and place characters in appropriate rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction at top or bottom row
            if (currentRow == 0) {
                goingDown = true;
            } else if (currentRow == numRows - 1) {
                goingDown = false;
            }
            
            // Move to next row
            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        
        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}