class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int res = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            res=Math.min(res,nums[mid]);
        }
        return res;
    }
}