class Solution {
    public int bagOfTokensScore(int[] token, int power) {
        Arrays.sort(token);
        int score = 0;
        int i=0,j=token.length-1;
        int curr=0;
        while(i<token.length && j>=0 && i<=j){
            if((power-token[i])>=0){
                power-=token[i];
                curr++;
                i++;
                score = Math.max(curr,score);
            }
            else if((power-token[i])<0 && curr>0){
                power+=token[j];
                j--;
                curr--;
            }
            else{
                return score;
            }
        }
        return score;
    }
}