// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int[] p=new int[nums.length/2];
//         int[] n=new int[nums.length/2];
//         int po=0,ne=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]<0) p[po++]=nums[i];
//             else n[ne++]=nums[i];
//         }
//         ne=0;po=0;
//         for(int i=0;i<nums.length;i++){
//             if(i%2!=0){
//                 nums[i]=p[po++];
//             }
//             else{
//                 nums[i]=n[ne++];
//             }
//         }

//         return nums;
        
//     }
// }

class Solution {
    public int[] rearrangeArray(int[] a) {
        int n = a.length;
        int pos=0,neg=1;
        int b[] = new int[n];
        for(int i=0;i<n;i++){
            if(a[i] > 0){
                b[pos] = a[i];
                pos += 2;
            }
            else{
                b[neg] = a[i];
                neg += 2;
            }
        }
        return b;
    }
}