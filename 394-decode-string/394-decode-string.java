class Solution {
    /*public String helper(String s,int i){
        String result = "";
        while(i<s.length() && s.charAt(i)!=']'){
            if(Character.isDigit(s.charAt(i))){
                int k=0;
                while(i< s.length() && Character.isDigit(s.charAt(i))){
                    k = k*10 + s.charAt(i++) -'0';
                }/*
            i++;
            String st = helper(s, i);
            result += st.repeat(k);
            i++;
            }
            else{
                result += s.charAt(i++);
            }
        }
        return result;
        
    }*/
    public String decodeString(String s) {
        String str = "";
        String num = "";
        
        Stack<String> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            
            //if(character is digit)
            if(Character.isDigit(s.charAt(i))){
                num += s.charAt(i);
            }
            
            //else if(char is '[')
            else if(s.charAt(i) == '['){
                stk.push(str);
                stk.push(num);
                str = "";
                num = "";
            }
            
            //else if(char is ']')
            else if(s.charAt(i) == ']'){
                int multiplystr = Integer.valueOf(stk.pop());
                str = stk.pop() + str.repeat(multiplystr);
            }
            
            //else (its character)
            else{
                str += s.charAt(i);
            }
        }
        
        return str;
    }
}