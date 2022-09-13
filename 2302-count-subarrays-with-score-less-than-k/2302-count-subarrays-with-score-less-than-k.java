class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0;
        long ans=0,sum=0;
        for(int j=0;j<nums.length;j++)
        {
            sum+=nums[j];
            while(((j-i+1)*sum)>=k)
            {
                sum-=nums[i++];
            }
            ans+=j-i+1;
        }
        return ans;
    }
}