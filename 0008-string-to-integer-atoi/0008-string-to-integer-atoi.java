class Solution {
    public int myAtoi(String s) {
        int sign=1;
        int idx=0;
        s=s.trim();
        if(s.length()==0)return 0;
        char[] arr = s.toCharArray();
        if(arr[0]=='-'){
            sign=-1;
            idx=1;
        }
        else if(arr[0]=='+'){
            sign=1;
            idx=1;
        }
        double ans=sign*helper(arr,0,idx);
        if(sign==1 && ans>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign==-1 && ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }
    public double helper(char[] s,double sum,int idx){
        if(idx>=s.length || Character.isDigit(s[idx])==false) return sum;
        int digit=(s[idx]-'0');
        sum=sum*10+digit;
        return helper(s,sum,idx+1);
    }
}