class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer>st=new Stack<>();
    
        for(int i=prices.length-1;i>=0;i--){
              int c=prices[i];
        while(!st.isEmpty()&&st.peek()>prices[i]){
            st.pop();
        }

     if(!st.isEmpty()) 
     prices[i]=c-st.peek();
        
        st.push(c);
        }
    
    return prices;

    }
}