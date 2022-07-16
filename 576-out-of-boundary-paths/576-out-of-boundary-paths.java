class Solution {
    long mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][] = new long[m+1][n+1][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return (int)solve(m,n,maxMove,startRow,startColumn,dp);
    }
    public long solve(int m, int n, int maxMove, int i, int j, long[][][] dp){
        if(maxMove<0){
            return 0;
        }
        if(i==m || j==n || i<0 || j<0){
            return 1;
        }
        if(dp[i][j][maxMove]!=-1){
            return dp[i][j][maxMove];
        }
        long count = 0;
        long left = solve(m,n,maxMove-1,i,j-1,dp);
        long right = solve(m,n,maxMove-1,i,j+1,dp);
        long up = solve(m,n,maxMove-1,i-1,j,dp); 
        long down = solve(m,n,maxMove-1,i+1,j,dp);
        count = (left+right+up+down)%mod;
        dp[i][j][maxMove] = count;
        return count;
    }
}