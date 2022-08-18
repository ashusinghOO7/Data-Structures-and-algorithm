class Solution {
    
    public boolean helper(char[][] board,int i,int j,String word , int wi, int vis[][]){
        if(wi==word.length()){
            return true;
        }
        if(i<0 || j<0 ||i>=board.length || j>=board[0].length){
            return false;
        }
        if(vis[i][j]==1 || word.charAt(wi)!=board[i][j]){
            return false;
        }
        vis[i][j] = 1;
        //System.out.println(word.charAt(wi));
            if(helper(board,i+1,j,word,wi+1,vis) || helper(board,i-1,j,word,wi+1,vis) || helper(board,i,j+1,word,wi+1,vis) || helper(board,i,j-1,word,wi+1,vis)){
                return true;
            }
        vis[i][j]=0;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int vis[][] = new int[board.length][board[0].length];
                if(board[i][j]==word.charAt(0) && helper(board,i,j,word,0,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}