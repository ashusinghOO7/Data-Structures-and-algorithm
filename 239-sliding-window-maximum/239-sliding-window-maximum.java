class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*int res[]=new int[nums.length-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        for(int i=0;i<k;i++){
            pq.add(i);
        }
        res[0] = nums[pq.peek()];
        for(int i=1;i<nums.length-k+1;i++){
            pq.remove(i-1);
            pq.add(i+k-1);
            res[i] = nums[pq.peek()];
        }
        return res;*/
        int n = nums.length;
  if (n == 0 || k == 0) {
    return new int[0];
  }
  int[] result = new int[n - k + 1]; // number of windows
  Deque<Integer> win = new ArrayDeque<>(); // stores indices
  
  for (int i = 0; i < n; ++i) {
    // remove indices that are out of bound
    while (win.size() > 0 && win.peekFirst() <= i - k) {
      win.pollFirst();
    }
    // remove indices whose corresponding values are less than nums[i]
    while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
      win.pollLast();
    }
    win.offerLast(i);
    if (i >= k - 1) {
      result[i - k + 1] = nums[win.peekFirst()];
    }
  }
  return result;
    }
}