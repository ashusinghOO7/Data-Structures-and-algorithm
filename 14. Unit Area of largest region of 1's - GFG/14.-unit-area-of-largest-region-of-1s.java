// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int solver(int[][] grid,int[][] vis,int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(grid[i][j]==1 && vis[i][j]==0){
            vis[i][j] = 1;
            return 1 + solver(grid,vis,i+1,j,n,m) + solver(grid,vis,i+1,j+1,n,m)
            + solver(grid,vis,i+1,j-1,n,m) + solver(grid,vis,i-1,j,n,m)
            + solver(grid,vis,i-1,j+1,n,m) + solver(grid,vis,i-1,j-1,n,m)
            + solver(grid,vis,i,j+1,n,m) + solver(grid,vis,i,j-1,n,m);
        }
        return 0;
    }
    public int findMaxArea(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j]==0){
                    res = Math.max(res,solver(grid,vis,i,j,n,m));
                }
            }
        }
        return res;
    }
}