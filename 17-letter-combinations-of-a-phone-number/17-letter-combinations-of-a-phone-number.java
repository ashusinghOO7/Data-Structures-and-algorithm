class Solution {
    List<String> al = new ArrayList<String>();
    public void helper(String digit,String ch[],int i,String str){
        if(i>=digit.length()){
            if(str!="")
                al.add(str);
            return;
        }
        
        int curr =  (digit.charAt(i)-'2');
        for(int j=0;j<ch[curr].length();j++){
            String c = str + ch[curr].charAt(j);
            helper(digit,ch,i+1,c);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        al = new ArrayList<String>();
        String ch[] ={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,ch,0,"");
        return al;
    }
}