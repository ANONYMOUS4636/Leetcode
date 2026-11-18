class Solution {
    class close implements Comparable<close>{
        int x;
        int dist;
        close(int x,int dist){
            this.x=x;
            this.dist=dist;
        }
        public int compareTo(close c){
            if(this.dist==c.dist) return this.x-c.x;
            return Double.compare(this.dist,c.dist);
        }

    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<close> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            int d=Math.abs(arr[i]-x);
            pq.add(new close(arr[i],d));
            if(pq.size()>k) pq.remove();
        }
        while(pq.size()>0){
            ans.add(pq.peek().x);
            pq.remove();
        }
        Collections.sort(ans);
        return ans;
    }
}