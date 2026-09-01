class Solution {
    public int evalRPN(String[] tokens) {
    Stack<Integer> st=new Stack<>();
 int result=0;
    for(String str:tokens){
     
      
           
           
            if(str.equals("+")){
                 int b = st.pop();
    int a = st.pop();
                result=a+b;
                st.push(result);
            }
            else if(str.equals("-")){
                 int b = st.pop();
    int a = st.pop();
                result=a-b;
                st.push(result);
            }
               else if(str.equals("*")){
                 int b = st.pop();
    int a = st.pop();
                result=a*b;
                st.push(result);
            }
               else if(str.equals("/")){
                 int b = st.pop();
    int a = st.pop();
                result=a/b;
                st.push(result);
            }
            else {
    int num = Integer.parseInt(str);
    st.push(num);
}
           
        
    }
      return st.peek();  
    }
}