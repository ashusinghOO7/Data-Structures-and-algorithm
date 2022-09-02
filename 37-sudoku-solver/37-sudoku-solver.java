class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char [][]board){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(char[][] board,int i,int j,char c){
        for(int k=0;k<9;k++){
            if(board[i][k]==c){
                return false;
            }
            if(board[k][j]==c){
                return false;
            }
            if(board[3 * (i/3) + k/3][3 * (j/3) + k%3]==c){
                return false;
            }
        }
        return true;
    }
}