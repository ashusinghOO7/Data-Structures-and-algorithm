class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else{
                if(!st.isEmpty()){
                    if(s.charAt(st.peek())=='('){
                        st.pop();
                    }
                    else{
                        st.push(i);
                    }
                }
                else{
                    st.push(i);
                }
            }
        }
        if(st.isEmpty()){
            return s.length();
        }
        int a = 0,b=s.length(),largest = 0;
        while(!st.isEmpty()){
            a=st.pop();
            largest = Math.max(largest,b-a-1);
            b = a;
        }
        return Math.max(largest,b);
    }
}