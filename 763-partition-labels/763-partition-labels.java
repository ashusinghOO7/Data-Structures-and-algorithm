class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> al = new ArrayList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),i);
        }
        int cnt=0,i=0;
        while(i<s.length()){
            int j=hm.get(s.charAt(i));
            if(i==j){
                al.add(1);
            }
            else{
                while(i<j && i<s.length()){
                    j=Math.max(j,hm.get(s.charAt(i)));
                    cnt++;
                    i++;
                }
                al.add(cnt+1);
                cnt = 0;
            }
            i++;
        }
        return al;
    }
}