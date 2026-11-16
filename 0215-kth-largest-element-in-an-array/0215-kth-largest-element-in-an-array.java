class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=nums.length-1;
        while(n>=0){
            if(pq.size()<k) pq.add(nums[n]);
            else{
                pq.add(nums[n]);
                pq.remove();
            }
            n--;
        }
        return pq.peek();
    }
}