class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()!=1){
            for(int i=1;i<=k-1;i++){
               q.add(q.remove()); 
            }
            //System.out.println(q);
            q.remove();
            //System.out.println(q);
            // for(int i=1;i<=q.size()-k+1;i++){
            //     q.add(q.remove());
            // }
        }

        return q.remove();
    }
}