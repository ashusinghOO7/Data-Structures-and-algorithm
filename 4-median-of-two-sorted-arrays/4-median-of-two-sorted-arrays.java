class Solution {
    public double findMedianSortedArrays(int[] arr, int[] brr) {
        int n = arr.length;
        int m = brr.length;
        if(m<n){
            return findMedianSortedArrays(brr,arr);
        }
        int low = 0, high = n;
        int left1=0,right1=0;
        int left2=0,right2=0;
        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = (n+m+1)/2 - cut1;
            left1 = cut1==0 ? Integer.MIN_VALUE:arr[cut1-1];
            left2 = cut2==0 ? Integer.MIN_VALUE:brr[cut2-1];
            right1 = cut1==n ? Integer.MAX_VALUE:arr[cut1];
            right2 = cut2==m ? Integer.MAX_VALUE:brr[cut2];
            
            if(left1<=right2 && left2<=right1){
                if((n+m)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }
                else{
                    return Math.max(left1,left2);
                }
            }
            else if(left1>right2){
                high = cut1-1;
            }
            else{
                low = cut1+1;
            }
        }
        return 0.0;
    }
}