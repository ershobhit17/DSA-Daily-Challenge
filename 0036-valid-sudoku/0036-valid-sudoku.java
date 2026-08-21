class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
            }
        }
        
        // Check columns
        for (int j = 0; j < 9; j++) {
            Set<Character> colSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (colSet.contains(board[i][j])) {
                        return false;
                    }
                    colSet.add(board[i][j]);
                }
            }
        }
        
        // Check 3x3 sub-boxes
        for (int box = 0; box < 9; box++) {
            Set<Character> boxSet = new HashSet<>();
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] != '.') {
                        if (boxSet.contains(board[i][j])) {
                            return false;
                        }
                        boxSet.add(board[i][j]);
                    }
                }
            }
        }
        
        return true;
    }
}