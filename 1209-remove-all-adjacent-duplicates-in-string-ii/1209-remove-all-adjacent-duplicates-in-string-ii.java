class Pair{
    char frst;int cnt;
    Pair(char c,int k){
        this.frst=c;
        this.cnt=k;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!st.isEmpty() && st.peek().frst==curr){
                if(st.peek().cnt+1==k){
                    st.pop();
                }
                else{
                    int c = st.pop().cnt;
                    st.push(new Pair(curr,c+1));
                }
            }
            else{
                st.push(new Pair(curr,1));
            }
        }
        String res = "";
        while(!st.isEmpty()){
            int x = st.peek().cnt;
            char c = st.pop().frst;
            while(x-->0){
                res = c + res;
            }
            
        }
        return res;
    }
}