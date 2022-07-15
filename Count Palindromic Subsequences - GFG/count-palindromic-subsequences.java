// { Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long countPS(String str)
    {
        int MOD = 1000000007;
        int n = str.length();
        long dp[][] = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int g = 1; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] + 1) % MOD;
                else
                    dp[i][j] = (MOD + dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]) % MOD;
            }
        }
        return dp[0][n - 1];
    }
}