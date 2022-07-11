class Solution {
    public int numTrees(int n) {
        long t[] = new long[n+1];
        t[0] = 1;
        for(int i=1;i<n+1;i++){
            t[i] = t[i-1]*(2*(2*i - 1));
            t[i] = t[i]/(i+1);
        }
        //Your code here
        return (int) t[n];
    }
}