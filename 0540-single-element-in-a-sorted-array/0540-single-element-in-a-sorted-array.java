class Solution {
    public int singleNonDuplicate(int[] arr) {
        
        if(arr.length==1) return arr[0];
        else if(arr[0]!=arr[1]) return arr[0];
        else if(arr[arr.length-1]!=arr[arr.length-2]) return arr[arr.length-1];
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==arr[mid+1]){
                if((mid+1)%2==0) high=mid-1;
                else low=mid+1;
            }
            else if(arr[mid]==arr[mid-1]){
                if(mid%2==0) high=mid-1;
                else low=mid+1;
            }
            else{
                break;
            }
        }
        return arr[mid];
    }
} 
