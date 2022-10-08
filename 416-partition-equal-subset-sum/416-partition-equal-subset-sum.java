class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
        int n = nums.length;
        boolean subset[][] = new boolean[sum + 1][n + 1];
  
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;
  
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;
  
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j]=subset[i][j-1];
                if (i >= nums[j - 1])
                    subset[i][j] = subset[i][j]
                                   || subset[i - nums[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }
}