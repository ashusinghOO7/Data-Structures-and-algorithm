class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        if(nums[0]==0){
            return false;
        }
        int maxP = nums[0],jump=nums[0];
        for(int i = 1;i<nums.length;i++){
            if(i==nums.length-1){
                return true;
            }
            maxP=Math.max(maxP,nums[i]+i);
            jump--;
            if(jump==0){
                jump=maxP-i;
                if(jump<=0){
                    return false;
                }
            }
        }
        return false;
    }
}