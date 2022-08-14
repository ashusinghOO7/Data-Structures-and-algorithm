class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st =  new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int curr = st.pop() + st.pop();
                st.push(curr);
                continue;
            }
            else if(tokens[i].equals("-")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v2-v1);
            }
            else if(tokens[i].equals("*")){
                int curr = st.pop() * st.pop();
                st.push(curr);
            }
            else if(tokens[i].equals("/")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v2/v1);
            }
            else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();
    }
}