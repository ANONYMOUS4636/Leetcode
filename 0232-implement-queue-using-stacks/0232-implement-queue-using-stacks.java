class MyQueue {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> hel=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while(st.size()>1){
            hel.push(st.pop());
        }
        int ans=st.pop();
        while(hel.size()>0){
            st.push(hel.pop());
        }
        return ans;
    }
    
    public int peek() {
                while(st.size()>1){
            hel.push(st.pop());
        }
        int ans=st.peek();
        while(hel.size()>0){
            st.push(hel.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */