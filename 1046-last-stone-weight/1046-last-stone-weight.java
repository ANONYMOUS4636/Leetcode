class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
       for(int ele:stones){
        pq.add(ele);
       } 
       if(pq.size()==1) return pq.peek();
       while(pq.size()>1){
        int a=pq.remove();
        int b=pq.remove();
        pq.add((a>b)?a-b:b-a);
        }
        return pq.peek();
    }
}