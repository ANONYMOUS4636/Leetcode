class Solution {
    public int kthSmallest(int[][] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(pq.size()<k) pq.add(nums[i][j]);
                else{
                    pq.add(nums[i][j]);
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
}