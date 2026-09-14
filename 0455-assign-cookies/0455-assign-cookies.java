class Solution {
    public int findContentChildren(int[] greed, int[] cookie) {
                Arrays.sort(greed);
        Arrays.sort(cookie);
        int count=0;
       int i=0,j=0;
            while(i<greed.length&&j<cookie.length){
                if(cookie[j]>=greed[i]){
                    count++;
                    i++;
                    j++;
                
                
            }
            else j++;
        }
        return count;
    }

    }
