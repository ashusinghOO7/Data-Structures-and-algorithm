class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int res=0;
        int sum=0;
        for(int i:nums){
            sum+=i;
            res+=hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return res;
    }
}