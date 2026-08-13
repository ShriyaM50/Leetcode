class Solution {
    public String removeDuplicates(String s) {
       Stack<Character> st=new Stack<>();
       for(char c:s.toCharArray()){
       if(!st.isEmpty()&&st.peek()==c){
        st.pop();
       }
       else{
        st.push(c);
       }
       }
     StringBuilder str=new StringBuilder();
     while(!st.isEmpty()){
        str.append(st.pop());
     }
     return str.reverse().toString();
    }
}