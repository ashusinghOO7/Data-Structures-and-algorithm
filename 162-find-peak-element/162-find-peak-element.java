class Solution {
    public int findPeakElement(int[] a) {
        int l=0;
        int h=a.length;
        while(l<=h){
            int mid=(l+h)/2;
            if((mid==0 || a[mid]>a[mid-1]) && (mid==a.length-1 || a[mid]>a[mid+1] )){
                return mid;
            }
            else if(mid>0 && a[mid]<a[mid-1]) {
                h=mid-1;
				}
            else{
			    l=mid+1;
			}
            
        }
        return -1;
    }
}