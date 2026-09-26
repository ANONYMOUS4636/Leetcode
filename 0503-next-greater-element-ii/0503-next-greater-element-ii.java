class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(st.isEmpty()) {
                st.push(arr[i]);
                ans[i]=-1;
            }
            else if(arr[i]<st.peek()){
                ans[i]=st.peek();
                st.push(arr[i]);
            }
            else if(arr[i]>=st.peek()){
                while(!st.isEmpty() && st.peek() <= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()) ans[i]=-1;
                else ans[i]=st.peek();
                st.push(arr[i]);
            }
        }
                for(int i=arr.length-1;i>=0;i--){
            if(st.isEmpty()) {
                st.push(arr[i]);
                ans[i]=-1;
            }
            else if(arr[i]<st.peek()){
                ans[i]=st.peek();
                st.push(arr[i]);
            }
            else if(arr[i]>=st.peek()){
                while(!st.isEmpty() && st.peek() <= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()) ans[i]=-1;
                else ans[i]=st.peek();
                st.push(arr[i]);
            }
        }
        return ans;
    }
}