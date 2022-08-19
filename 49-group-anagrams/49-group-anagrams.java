class Solution {
    public List<List<String>> groupAnagrams(String[] string_list) {
        String sorted[] = new String[string_list.length];
        for(int i=0;i<sorted.length;i++){
            char[] c = string_list[i].toCharArray();
            Arrays.sort(c);
            sorted[i] = new String(c);
        }
        HashMap<String,ArrayList<String>> m = new HashMap<>();
        for(int i=0;i<sorted.length;i++){
            if(!m.containsKey(sorted[i])){
                m.put(sorted[i],new ArrayList<>());
            }
            m.get(sorted[i]).add(string_list[i]);
        }
        List<List<String>> al = new ArrayList<>();
        for(Map.Entry<String , ArrayList<String>>entry : m.entrySet())
            al.add(entry.getValue());
        
        return al;
    }
}