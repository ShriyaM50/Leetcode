class Solution {
    public boolean checkDivisibility(int n) {
        int digit=0;
        int orig=n;
        int sum=0;
        int prod=1;
        while(n>0){
            digit=n%10;
            n/=10;
            sum+=digit;
        prod*=digit;
        }
        
  return orig % (sum + prod) == 0;
    }
}