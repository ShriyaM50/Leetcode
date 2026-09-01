class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] parts = path.split("/");
        for(String str:parts){
            if(!str.equals("") &&!str.equals(".")&&!str.equals("..")){
                st.push(str);

            }
            else if(str.equals("..")) {
            if(!st.isEmpty()){
                    st.pop();
                }
            }
            
        }
        if (st.isEmpty()) {
    return "/";
}
      StringBuilder result = new StringBuilder();

     for(String dir : st) {
    result.append("/").append(dir);
}

return result.toString();
    }
}