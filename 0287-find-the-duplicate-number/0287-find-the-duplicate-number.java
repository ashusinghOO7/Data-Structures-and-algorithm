class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0],fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }
        fast = nums[0];
        while(slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
        
    }
}