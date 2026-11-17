class Solution {
    class dist implements Comparable<dist>{
        int i;
        int j;
        int d;
        dist(int i,int j,int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
        public int compareTo(dist d){
            return Double.compare(this.d,d.d);
        }
    }
    public int[][] kClosest(int[][] arr, int k) {
        PriorityQueue<dist> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[][] ans=new int[k][2];
        for(int i=0;i<arr.length;i++){
            int d=(arr[i][0]*arr[i][0])+(arr[i][1]*arr[i][1]);
            pq.add(new dist(arr[i][0],arr[i][1],d));
            if(pq.size()>k) pq.remove();
        }
        for(int i=0;i<k;i++){
            ans[i][0]=pq.peek().i;
            ans[i][1]=pq.peek().j;
            pq.remove();
        }
        return ans;
    }
}