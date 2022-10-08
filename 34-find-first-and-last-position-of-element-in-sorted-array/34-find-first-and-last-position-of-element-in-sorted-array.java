class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1,-1};
        int low = 0,high = nums.length-1,ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>target){
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        res[0]=ans;
        low = 0;high = nums.length-1;ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>target){
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                ans=mid;
                low=mid+1;
            }
        }
        res[1]=ans;
        return res;
    }
}