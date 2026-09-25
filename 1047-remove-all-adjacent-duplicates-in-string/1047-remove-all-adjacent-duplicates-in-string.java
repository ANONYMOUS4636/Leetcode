class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        String str="";
        // st.push(s.charAt(0));
        for(int i=s.length()-1;i>=0;i--){
            if(st.isEmpty()) st.push(s.charAt(i));
            else if(st.peek()!=s.charAt(i)) st.push(s.charAt(i));
            else if(st.peek()==s.charAt(i)) st.pop();  
        }
        while(st.size()!=0){
            str=str+st.pop();
        }
        return str;
    }
}