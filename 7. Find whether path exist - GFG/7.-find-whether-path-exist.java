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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean solver(int i,int j,int[][] grid,int visited[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] == 1){
            return false;
        }
        if(grid[i][j]==2){
            return true;
        }
        else if(grid[i][j] == 0){
            return false;
        }
        visited[i][j] = 1;
        return solver(i-1,j,grid,visited) || solver(i,j-1,grid,visited) || solver(i+1,j,grid,visited) ||solver(i,j+1,grid,visited);
    }
    public boolean is_Possible(int[][] grid)
    {
        int [][]visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    return solver(i,j,grid,visited);
                }
            }
        }
        return false;
    }
}