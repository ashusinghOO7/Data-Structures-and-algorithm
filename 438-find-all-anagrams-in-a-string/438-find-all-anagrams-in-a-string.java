class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()<p.length()){
            return res;
        }
        int cnt1[] = new int[256];
        int cnt2[] = new int[256];
        for(int i=0;i<p.length();i++){
            cnt1[p.charAt(i)-'a']++;
            cnt2[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(cnt1,cnt2)){
            res.add(0);
        }
        for(int i=0;i<s.length()-p.length();i++){
            cnt2[s.charAt(i)-'a']--;
            cnt2[s.charAt(i+p.length())-'a']++;
            if(Arrays.equals(cnt1,cnt2)){
                res.add(i+1);
            }
        }
        
        return res;
    }
}