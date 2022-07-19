class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int res = Integer.MAX_VALUE;
        int dp[][] = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = Math.min(0,dungeon[i][j]);
                }
                else if(i==n-1){
                    dp[i][j] = Math.min(0,dungeon[i][j] + dp[i][j+1]);
                }
                else if(j==m-1){
                    dp[i][j] = Math.min(0,dungeon[i][j] + dp[i+1][j]);
                }
                else{
                    dp[i][j] = Math.min(0,Math.max(dp[i+1][j],dp[i][j+1])+dungeon[i][j]);
                }
            }
        }
        return Math.abs(dp[0][0])+1;
    }
}