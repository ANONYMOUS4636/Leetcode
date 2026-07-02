class Solution {
    public int findPeakElement(int[] arr) {
        if(arr.length==1) return 0;
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(mid+1<arr.length && arr[mid]<arr[mid+1]){
                low=mid+1;
            }
            else if(mid-1>=0 && arr[mid]<arr[mid-1]){
                high=mid-1;
            }
            else{
                break;
            }
        }
        return mid;
    }
}