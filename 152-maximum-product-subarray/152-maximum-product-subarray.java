class Solution {
    public int maxProduct(int[] nums) {
        int negative = nums[0];
        int positive = nums[0];
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = positive;
                positive = Math.max(nums[i],negative*nums[i]);
                negative = Math.min(nums[i],temp*nums[i]);
            }
            else{
                positive = Math.max(nums[i],positive*nums[i]);
                negative = Math.min(nums[i],negative*nums[i]);
            }
            res = Math.max(res,positive);
        }
        return res;
    }
}