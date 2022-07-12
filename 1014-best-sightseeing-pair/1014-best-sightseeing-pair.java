class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res=0,curr=0;
        for(int i:values){
            res = Math.max(res,curr+i);
            curr = Math.max(curr,i)-1;
        }
        return res;
    }
}