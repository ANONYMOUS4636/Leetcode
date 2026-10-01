class Solution {
    public int maximalRectangle(char[][] ans) {
            class twin{
            int val;
            int idx;
            twin(int val,int idx){
                this.val=val;
                this.idx=idx;
            }
        }
        if(ans.length == 0 || ans[0].length == 0) return 0;
        int[][] arr=new int[ans.length][ans[0].length];
        Stack<twin> st=new Stack<>();
        int[] nse=new int[arr[0].length];
        int[] pse=new int[arr[0].length];
        int max=0;
        //prefix sum

        for(int i=0;i<arr[0].length;i++){
            if(ans[0][i]=='1') arr[0][i]=1;
            else if(ans[0][i]=='0') arr[0][i]=0;
            for(int j=1;j<arr.length;j++){
                if(ans[j][i]!='0') arr[j][i] = (ans[j][i] - '0') + arr[j-1][i];
                else arr[j][i]=0;
            }
        }
        //leetcode 84

        for(int j=arr.length-1;j>=0;j--){
            nse[nse.length-1]=nse.length;
            st.push(new twin(arr[j][arr[0].length-1],arr[0].length-1));
            for(int i=arr[0].length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek().val>=arr[j][i]) st.pop();
if(st.isEmpty()){
    nse[i]=arr[0].length;
}
else{
    nse[i]=st.peek().idx;
}
st.push(new twin(arr[j][i],i));
        }
        st.clear();
        pse[0]=-1;
        st.push(new twin(arr[j][0],0));
            for(int i=1;i<arr[0].length;i++){
            while(!st.isEmpty() && st.peek().val>=arr[j][i]) st.pop();
if(st.isEmpty()){
    pse[i]=-1;
}
else{
    pse[i]=st.peek().idx;
}
st.push(new twin(arr[j][i],i));
        }
        
for(int i=0;i<arr[0].length;i++){
    int width = nse[i] - pse[i] - 1;
    max = Math.max(max, arr[j][i] * width);
}
        
st.clear();

        }

        return max;
    }
}