class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        Stack <Integer>st=new Stack<>();
        for(String ch:operations){
           
            if(ch.equals("C")){
                st.pop();
            }
            else if(ch.equals("D")){
                st.push(st.peek()*2);
            
            }
            else if(ch.equals("+")){
                int a=st.pop();
                int b=st.peek();
                st.push(a);
                st.push(a+b);

            }
            else{
                st.push(Integer.parseInt(ch));
                }
        }
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}