class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] p=new int[nums.length/2];
        int[] n=new int[nums.length/2];
        int po=0,ne=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) p[po++]=nums[i];
            else n[ne++]=nums[i];
        }
        ne=0;po=0;
        for(int i=0;i<nums.length;i++){
            if(i%2!=0){
                nums[i]=p[po++];
            }
            else{
                nums[i]=n[ne++];
            }
        }

        return nums;
        
    }
}