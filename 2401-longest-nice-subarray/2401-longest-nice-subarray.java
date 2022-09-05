class Solution {
    public int longestNiceSubarray(int[] A) {
        /*int res = 1;
        int curr = 1;
        int or = nums[0];
        for(int i=1;i<nums.length;i++){
            if((or & nums[i])==0){
                or = or | nums[i];
                curr++;
                res=Math.max(curr,res);
            }
            else{
                curr=1;
                or = nums[i];
            }
        }
        res=Math.max(curr,res);
        return res;*/
        int AND = 0, i = 0, res = 0, n = A.length;
        for (int j = 0; j < n; ++j) {
            while ((AND & A[j]) > 0)
                AND ^= A[i++];
            AND |= A[j];
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}