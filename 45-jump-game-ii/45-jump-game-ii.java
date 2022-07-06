class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1 || nums[0]==0){
            return 0;
        }
        int maxP = nums[0],jump=nums[0],res = 1;
        for(int i = 1;i<nums.length;i++){
            if(i==nums.length-1){
                return res;
            }
            maxP = Math.max(maxP,i+nums[i]);
            jump--;
            if(jump==0){
                res++;
                jump = maxP-i;
                if(jump<=0){
                    return -1;
                }
            }
        }
        return res;
    }
}