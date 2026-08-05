class Solution {
    public boolean isSubsequence(String s, String t) {
       
        int n=s.length();
        int tn=t.length();
        int i=0;
        int j=0;
        while(i<n&&j<tn){

                if(s.charAt(i)==t.charAt(j)){

                    i++;
                    j++;
                }
                else
                    j++;
               
            }
            if(i==n)
               return true;
               else return false;
        }
     
    
}