class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(k>n/2){
            //(n-k) smallest 
            k = (n-k+1);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<k;i++){
                pq.add(nums[i]);
            }
            for(int i=k;i<nums.length;i++){
                if(pq.peek()>nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            return pq.poll();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
                pq.add(nums[i]);
            }
            for(int i=k;i<nums.length;i++){
                if(pq.peek()<nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            return pq.poll();
    }
}