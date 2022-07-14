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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends


class Pair{
    int frst;int scnd;
    Pair(int x,int y){
        frst = x;
        scnd = y;
    }
}

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        Pair[] arr = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr,(x,y)->x.frst-y.frst);
        int res = 0;
        boolean vis[] = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(vis[i]==true || arr[i].scnd==i){
                continue;
            }
            int cLen = 0;
            int j =i;
            while(vis[j] == false){
                vis[j] = true;
                cLen++;
                j = arr[j].scnd;
            }
            res += (cLen - 1);
        }
        return res;
    }
}