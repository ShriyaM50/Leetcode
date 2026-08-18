class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
               if(st.isEmpty()||st.peek()!='('){
                    return false;
                }
                st.pop();
            }
            if(ch=='{')
            {
                st.push(ch);
            }
            else if(ch=='}'){
                 if(st.isEmpty()||st.peek()!='{'){
                    return false;
                }
                st.pop();
            }
            if(ch=='[') st.push(ch);
            else if(ch==']') {
                if(st.isEmpty()||st.peek()!='['){
                    return false;
                }
                st.pop();
            }
        }
            return st.isEmpty();
            
           
    }
}