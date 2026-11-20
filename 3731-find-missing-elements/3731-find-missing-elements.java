class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> h=new HashSet<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
            if(nums[i]>max) max=nums[i];
            if(nums[i]<min) min=nums[i];
        }
        for(int i=min;i<=max;i++){
            if(!h.contains(i)) ans.add(i);
        }
        return ans;
    }
}