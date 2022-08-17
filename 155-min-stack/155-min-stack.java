class MinStack {

    long min;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<Long>();
        min = -1;
    }
    public void push(int val) {
        if(st.isEmpty()){
            min=val;
            st.push((long)val);
        }
        else{
            if(val>=min){
                st.push((long)val);
            }
            else{
                st.push(2*(long)val-min);
                min = (long)val;
            }
        }
    }
    public void pop() {
        if(st.isEmpty()){
            return ;
        }
        else {
            long curr=st.pop();
            if(curr>min){
                return;
            }
            else{
                min = 2*min - curr;
                return;
            }
        }
    }
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        else {
            long curr=st.peek();
            if(curr>=min){
                return (int)curr;
            }
            else{
                return (int)min;
            }
        }
    }
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */