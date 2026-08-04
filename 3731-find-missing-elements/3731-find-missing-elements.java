class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
       List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
      
        for(int i=0;i<n-1;i++){
           int diff=nums[i+1]-nums[i];
            if(diff>1){
                for(int j=nums[i]+1;j<nums[i+1];j++){
                    ans.add(j);
                }
            }
            
        }
      return ans;
    }
}