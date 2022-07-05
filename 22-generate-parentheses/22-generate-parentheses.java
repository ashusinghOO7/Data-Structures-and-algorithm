class Solution {
    public List<String> al = new ArrayList<>();
    public void solver(int open , int close ,String str){
        if(open==0 && close==0){
            al.add(str);
            return;
        }
        if(open!=0){
            String str1 = str;
            str1 += "(";
            solver(open-1,close,str1);
        }
        if(open<close){
            String str2 = str;
            str2 += ")";
            solver(open,close-1,str2);
            return;
        }
    }
    public List<String> generateParenthesis(int n) {
        al = new ArrayList<>();
        solver(n,n,"");
        return al;
    }
}