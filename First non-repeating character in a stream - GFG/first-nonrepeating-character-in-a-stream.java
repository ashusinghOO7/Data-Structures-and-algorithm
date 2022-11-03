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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q = new LinkedList<>();
        int vis[] = new int[256];
        String B="";
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            vis[c-'a']++;
            q.add(c);
            while(!q.isEmpty() && vis[q.peek()-'a']>1){
                q.poll();
            }
            B += !q.isEmpty() ? q.peek() : '#';
        }
        return B;
    }
}