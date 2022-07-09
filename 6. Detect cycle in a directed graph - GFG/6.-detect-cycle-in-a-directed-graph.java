// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean solver(int i, ArrayList<ArrayList<Integer>> adj,int[] vis,int[] DFSvis){
        vis[i] = 1;
        DFSvis[i] = 1;
        for(int j:adj.get(i)){
            if(vis[j]==0){
                if(solver(j,adj,vis,DFSvis)==true){
                    return true;
                }
            }
            else if(DFSvis[j]==1){
                return true;
            }
        }
        DFSvis[i] = 0;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[adj.size()];
        int DFSvis[] = new int[adj.size()];
        for(int i=0;i<V;i++){
            if(solver(i,adj,vis,DFSvis)==true){
                return true;
            }
        }
        return false;
    }
}