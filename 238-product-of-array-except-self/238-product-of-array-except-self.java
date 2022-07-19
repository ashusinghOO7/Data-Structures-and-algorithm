class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int mult=1;
        for(int i=n-1;i>=0;i--){
            res[i] = mult*nums[i];
            mult*=nums[i];
        }
        mult = 1;
        for(int i=0;i<n-1;i++){
            res[i] = mult*res[i+1];
            mult *= nums[i];
        }
        res[n-1]=mult;
        return res;
    }
}