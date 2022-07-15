class Solution {
    public int solve(int[][] grid, boolean vis[][],int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        if(!vis[i][j]){
            vis[i][j] = true;
            return 1+ solve(grid,vis,i+1,j,n,m) + 
            solve(grid,vis,i,j+1,n,m) + 
            solve(grid,vis,i,j-1,n,m) +
            solve(grid,vis,i-1,j,n,m);
            
        }
        return 0;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int cnt=0;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    cnt = Math.max(cnt,solve(grid,vis,i,j,n,m));
                }
            }
        }
        return cnt;
    }
}