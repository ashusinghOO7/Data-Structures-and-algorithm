class Solution {
    int[] nums;
    Random r;
    int[] orig;
    public Solution(int[] nums) {
        orig = nums.clone();
        r = new Random();
        this.nums = nums;
    }
    
    public int[] reset() {
        return orig;
    }
    
    public int[] shuffle() {
        for(int i = 0; i < nums.length; i++) {
            int random = getRand(i, nums.length - 1);
            int tmp = nums[i];
            nums[i] = nums[random];
            nums[random] = tmp;
        }
        return nums;
    }
    //get a random number among [i, j].
    private int getRand(int i, int j) {
        return i + r.nextInt(j - i + 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */