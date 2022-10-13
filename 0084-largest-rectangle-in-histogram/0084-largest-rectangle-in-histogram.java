class Solution {
    public int largestRectangleArea(int[] hist) {
        
        Stack<Integer> st = new Stack<>();
        
        int m  = hist.length;
        int next[] = new int[m];
        int prev[] = new int[m];
        st.push(-1);
        for(int i=0;i<m;i++){
            while(st.peek()!=-1 && hist[st.peek()]>=hist[i]){
                st.pop();
            }
            prev[i]=st.peek();
            st.push(i);
        }
        st = new Stack<>();
        st.push(-1);
        for(int i=m-1;i>=0;i--){
            while(st.peek()!=-1 && hist[st.peek()]>=hist[i]){
                st.pop();
            }
            next[i]=(st.peek()==-1)?m:st.peek();
            st.push(i);
        }
        int res=0;
        for(int i=0;i<m;i++){
            int curr = (next[i]-prev[i]-1) * hist[i];
            res=Math.max(curr,res);
        }
        return res;
    }
}