class Solution {
    long dp[][] = new  long[2][100001];
    long util(int i, int[] nums, boolean isPos){
        if(i>=nums.length)return 0;
        if(dp[(isPos)?1:0][i]!=-1)return dp[(isPos)?1:0][i];
        long curr = (isPos?nums[i]:-1*nums[i]);
        return dp[(isPos)?1:0][i] = Math.max(curr + util(i+1, nums, !isPos), util(i+1, nums, isPos));
    }
    public long maxAlternatingSum(int[] nums) {
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        return util(0, nums, true);
    }
}