class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check all rows are valid or not.
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                if (set.contains(board[row][col])){
                    return false;
                } else {
                    set.add(board[row][col]);
                }
            }
        }
        
        // Check all cols are valid or not.
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[col][row] == '.') continue;
                if (set.contains(board[col][row])){
                    return false;
                } else {
                    set.add(board[col][row]);
                }
            }
        }
        
        // Check the box is valid or not.
        for (int row = 0; row < 9; row+=3) {
            for (int col = 0; col < 9; col+=3) {
                int startRow = row;
                int endRow = row + 2;
                int startCol = col;
                int endCol = col +2;
                
                if (!isValidBox(board, startRow, endRow, startCol, endCol)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValidBox(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        Set<Character> set = new HashSet<>();
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
