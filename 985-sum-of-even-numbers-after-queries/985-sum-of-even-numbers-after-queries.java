class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for(int i:nums){
            if(i%2==0){
                evenSum+=i;
            }
        }
        int res[] = new int[queries.length];
        int j=0;
        for(int i[]:queries){
            if(nums[i[1]]%2==0){
                evenSum -= nums[i[1]];
            }
            if((nums[i[1]]+i[0])%2==0){
                evenSum += nums[i[1]]+i[0];
            }
            nums[i[1]]+=i[0];
            res[j++]=evenSum;
            
        }
        return res;
    }
}