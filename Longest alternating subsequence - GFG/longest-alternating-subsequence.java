// { Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.AlternatingaMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int AlternatingaMaxLength(int[] arr)
    {
        int count = 1;
        int lcount = 1;
        int prev = arr[0];
        for(int i=1;i<arr.length;i++){
            if(count%2==0){
                if(prev>arr[i]){
                    count++;
                }
                prev = arr[i];
            }
            else{
                if(prev<arr[i]){
                    count++;
                }
                prev = arr[i];
            }
        }
        prev = arr[0];
        for(int i=1;i<arr.length;i++){
            if(lcount%2==0){
                if(prev<arr[i]){
                    lcount++;
                }
                prev = arr[i];
            }
            else{
                if(prev>arr[i]){
                    lcount++;
                }
                prev = arr[i];
            }
        }
        return Math.max(count,lcount);
    }
}