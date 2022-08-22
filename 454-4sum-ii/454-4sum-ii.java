class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                hm.put(i+j,hm.getOrDefault(i+j,0)+1);
            }
        }
        int count = 0;
        for(int i:nums3){
            for(int j:nums4){
                if(hm.containsKey(0-i-j)){
                    count += hm.get(0-i-j);
                }
            }
        }
        return count;
    }
}