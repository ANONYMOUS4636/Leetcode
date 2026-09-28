class Solution {
    public int[] canSeePersonsCount(int[] arr) {

        Stack<Integer> st=new Stack<>();
        int[] ans=new int[arr.length];
        ans[arr.length-1]=0;
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
                count++;
            }
            if(st.size()>0) count++;
            ans[i]=count;
            st.push(arr[i]);
        }
        return ans;
    }
}