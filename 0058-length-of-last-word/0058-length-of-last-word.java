class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int count=0;
        StringBuilder sb=new StringBuilder(s);
        sb=sb.reverse();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==' '&& count==0) {
              continue;
            }
            else if(sb.charAt(i)!=' '){
                count++;
            }
            else break;
        }
        return count;
    }
}