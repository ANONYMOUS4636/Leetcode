class Solution {
    public int firstMissingPositive(int[] arr) {
        int n=arr.length;
        int i=0;
        while(i<n){
            if(arr[i]==i+1||arr[i]>n||arr[i]<1||arr[i]==arr[arr[i]-1])i++;
            else{
                swap(arr,i,arr[i]-1);
            }
        }
        
            for(int j=0;j<arr.length;j++){
            if (arr[j] != j + 1) return j+1;
        }
        return n+1;
    }
        static void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
