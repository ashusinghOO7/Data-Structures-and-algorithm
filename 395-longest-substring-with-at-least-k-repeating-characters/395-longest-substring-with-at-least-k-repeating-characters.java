class Solution {
    public int longestSubstring(String s, int k) {
        int N = s.length();
        return helper(s.toCharArray(),0,N,k);
    }
    private int helper(char[] arr, int curr, int N, int k) {
        if ((N-curr) < k)
            return 0;

        int[] freq = new int[26];
        for (int i=curr; i<N; i++) 
            freq[arr[i]-'a']++;

        for (int i=curr; i<N; i++) 
            if (freq[arr[i]-'a'] < k) 
                return Math.max(helper(arr, curr, i, k), helper(arr, i+1, N, k));

        return N - curr;
    }
}