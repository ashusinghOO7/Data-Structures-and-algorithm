class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> al = new ArrayList<>();
    public void helper(int []cand,int currSum,int target,int currIndex){
        if(currSum>target){
            return;
        }
        if(currSum==target){
            res.add(new ArrayList(al));
        }
        for(int i=currIndex;i<cand.length;i++){
            al.add(cand[i]);
            currSum+=cand[i];
            helper(cand,currSum,target,i);
            al.remove(al.size()-1);
            currSum-=cand[i];
        }
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        al = new ArrayList<>();
        helper(candidates,0,target,0);
        return res;
    }
}