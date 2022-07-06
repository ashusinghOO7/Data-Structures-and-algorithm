// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    List<String> al = new ArrayList<>();
    public void solve(int open ,int close, String str){
        if(open==0 && close ==0){
            al.add(str);
        }
        if(open!=0){
            String str2 = str;
            str2 += "(";
            solve(open-1,close,str2);
        }
        if(close>open){
            String str2 = str;
            str2 += ")";
            solve(open,close-1,str2);
        }
    }
    public List<String> AllParenthesis(int n) 
    {
        solve(n,n,"");
        return al;
    }
}