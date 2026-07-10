class Solution {
    public int reversePairs(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        int[] a=new int[n/2];
        int[] b=new int[n-n/2];
        int idx=0;
        for(int i=0;i<a.length;i++) a[i]=arr[idx++];
        for(int i=0;i<b.length;i++) b[i]=arr[idx++];
        int count=0;
        int x=reversePairs(a);
        int y=reversePairs(b);
        count=x+y;
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if((long)a[i]>(long)2*(long)b[j]){
                count+=a.length-i;
                j++;
            }
            else{
                i++;
            }
        }
        merge(a,b,arr);
        return count;
    }
        static void merge(int[] a,int[] b,int[] arr){
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]>b[j]) arr[k++]=b[j++];
            else arr[k++]=a[i++];
        }
        while(i<a.length) arr[k++]=a[i++];
        while(j<b.length) arr[k++]=b[j++];
    }
}