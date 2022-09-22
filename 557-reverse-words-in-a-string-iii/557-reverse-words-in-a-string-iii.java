class Solution {
    public static String reverse(String s){
        char c[] = s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            char temp = c[i];
            c[i]=c[j];
            c[j]=temp;
            i++;
            j--;
        }
        return new String(c);
    }
    public String reverseWords(String s) {
        String res="";
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                res+=reverse(s.substring(j,i));
                res+=" ";
                j=i+1;
            }
        }
        res+=reverse(s.substring(j));
        return res;
    }
}