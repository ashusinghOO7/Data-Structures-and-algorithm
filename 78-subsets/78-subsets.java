class Solution {
    List<List<Integer>> al = new ArrayList<>();
    public void helper(int[] nums , int i,List<Integer> a){
        if(i==nums.length){
            al.add(new ArrayList<>(a));
        }else{
            a.add(nums[i]);
            helper(nums,i+1,a);
            a.remove(a.size()-1);
            helper(nums,i+1,a);
        }
    }
    public List<List<Integer>> subsets(int[] nums){
    List<Integer> a = new ArrayList<>();
        helper(nums,0,a);
        return al;
    }
}