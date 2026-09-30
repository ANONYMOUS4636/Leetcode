class Solution {
    public int largestRectangleArea(int[] arr) {
        class twin{
            int val;
            int idx;
            twin(int val,int idx){
                this.val=val;
                this.idx=idx;
            }
        }
        Stack<twin> st=new Stack<>();
        int[] nse=new int[arr.length];
        int[] pse=new int[arr.length];
        nse[arr.length-1]=arr.length;
        st.push(new twin(arr[arr.length-1],arr.length-1));
        for(int i=arr.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek().val>=arr[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=arr.length;
                st.push(new twin(arr[i],i));
            }
            else if(st.peek().val<arr[i]){
                nse[i]=st.peek().idx;
                st.push(new twin(arr[i],i));
            }
        }
        while(st.size()>0) st.pop();
        pse[0]=-1;
        st.push(new twin(arr[0],0));
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && st.peek().val>=arr[i]) st.pop();
            if(st.isEmpty()){
                pse[i]=-1;
                st.push(new twin(arr[i],i));
            }
            else if(st.peek().val<arr[i]){
                pse[i]=st.peek().idx;
                st.push(new twin(arr[i],i));
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int width=nse[i]-pse[i]-1;
            max=Math.max(max,arr[i]*width);
        }
        return max;  
    }
}