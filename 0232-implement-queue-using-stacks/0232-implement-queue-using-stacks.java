class MyQueue { //pop and peek efficient
    Stack<Integer> st=new Stack<>();
    Stack<Integer> hel=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!st.isEmpty()){
            hel.push(st.pop());
        }
        st.push(x);
        while(!hel.isEmpty()){
            st.push(hel.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
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