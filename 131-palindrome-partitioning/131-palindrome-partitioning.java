class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<List<String>>();
        ArrayList<String> single = new ArrayList<String>();
        recur(s,answer,single);
        return answer;
        
    }
    
    public static void recur(String s, List<List<String>> answer, ArrayList<String>  single)
    {
        if(s.length()==0)
        {
            answer.add(new ArrayList<String>(single));
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String prefix=s.substring(0,i+1);
            String rest_of_string= s.substring(i+1);
            if(isPalindrome(prefix)){
                single.add(prefix); //DO
                recur(rest_of_string,answer,single); // RECUR
                single.remove(single.size()-1); //UNDO
                
            }
        }
    }
    public static boolean isPalindrome(String s)
    {
        int ri=s.length()-1;
        int li=0;
        while(li<ri)
        {
            if(s.charAt(ri)!=s.charAt(li))
            {
                return false;
            }
            ri--;
            li++;
        }
        return true;
    }
}