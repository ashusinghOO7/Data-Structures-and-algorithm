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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends

class Pair{
    int i;int j;
    Pair(int x,int y){
        i = x;
        j = y;
    }
}
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0]-1,KnightPos[1]-1));
        int r[] = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        int c[] = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int res=0;
        boolean vis[][] = new boolean[N][N];
        vis[KnightPos[0]-1][KnightPos[1]-1] = true;
        while(!q.isEmpty()){
            int k = q.size();
            while(k-->0){
                int currI = q.peek().i;
                int currJ = q.peek().j;
                q.poll();
                if(currI == TargetPos[0]-1 && currJ  == TargetPos[1]-1){
                    return res;
                }
                for(int j = 0;j<8;j++){
                    if(currI + r[j] < 0 || currJ + c[j] < 0 || currI + r[j] >= N || currJ + c[j] >=N){
                        continue;
                    }
                    if(!vis[currI + r[j]][currJ + c[j]]){
                        q.add(new Pair(currI+r[j],currJ+c[j]));
                        vis[currI + r[j]][currJ + c[j]] = true;
                    }
                }
            }
            res++;
        }
        return res;
    }
}