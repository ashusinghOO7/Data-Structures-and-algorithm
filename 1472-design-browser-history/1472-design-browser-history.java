class ListNode{
    String val;
    ListNode next;
    ListNode(String val){
        this.val = val;
        this.next = null;
    }
}


class BrowserHistory {
    Stack<ListNode> st;
    ListNode head;
    public BrowserHistory(String homepage) {
        st = new Stack<>();
        head = new ListNode(homepage);
        st.push(head);
    }
    
    public void visit(String url) {
        ListNode curr = st.peek();
        curr.next = new ListNode(url);
        curr = curr.next;
        st.push(curr);
    }
    
    public String back(int steps) {
        while(st.size()!=1 && steps-->0){
            st.pop();
        }
        
        return st.peek().val;
    }
    
    public String forward(int steps) {
        ListNode curr = st.peek();
        while(curr.next!=null && steps-->0){
            curr = curr.next;
            st.push(curr);
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */