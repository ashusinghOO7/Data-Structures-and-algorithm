class Solution {
    int dp[][];
    int helper(int nums[],int mul[],int i,int start,int len){
        if(i==mul.length){
            return 0;
        }
        if(dp[i][start]!=Integer.MIN_VALUE){
            return dp[i][start];
        }
        int end = len - (i-start);
dp[i][start] =  Math.max(mul[i]*nums[start] +  helper(nums,mul,i+1,start+1,len),mul[i]*nums[end] + helper(nums,mul,i+1,start,len));
        return dp[i][start];
    }
    public int maximumScore(int[] nums, int[] mul) {
        dp = new int[mul.length][nums.length];
        for(int i=0;i<mul.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return helper(nums,mul,0,0,nums.length-1);
    }
}