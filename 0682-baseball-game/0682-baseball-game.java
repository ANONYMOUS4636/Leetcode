class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st=new Stack<>();
        int temp=0,res=0;
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")) {
                st.pop();
                //System.out.println(st);
                }
            else if(ops[i].equals("D")) {
                st.push(st.peek()*2);
                //System.out.println(st);
                }
            else if(ops[i].equals("+")){
                temp=st.pop();
                res=st.peek()+temp;
                st.push(temp);
                st.push(res);
                //System.out.println(st);
            }
            else{
                st.push(Integer.parseInt(ops[i]));
                //System.out.println(st);
            }
        }
        //System.out.println(st);
        if(st.isEmpty()) {
            System.out.println("return 0");
            return 0;
            }
        int sum=0;
        while(st.size()!=0){
            sum+=st.peek();
            st.pop();
        }
        return sum;
    }
}