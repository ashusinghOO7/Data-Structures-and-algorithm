class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> rows[] = new HashSet[9]; 
        HashSet<Integer> cols[] = new HashSet[9];
        HashSet<Integer> blocks[] = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            blocks[i] = new HashSet<Integer>();
        }
            
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if(board[i][j] == '.') continue;
                
                int curr = board[i][j] - '0';
                if (rows[i].contains(curr) || cols[j].contains(curr) || blocks[(i/3)*3+j/3].contains(curr)) 
                    return false;
                
                rows[i].add(curr);
                cols[j].add(curr);
                blocks[(i/3)*3+j/3].add(curr);
            }
        }
        
        return true;
    }
}