//Leetcode submition link: https://leetcode.com/problems/3sum/submissions/1883691528/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int Total=nums[i]+nums[j]+nums[k];
                if(Total<0){
                    j++;
                }
                else if(Total>0){
                    k--;
                }
                else{
                    arr.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(nums[j]==nums[j-1] && j<k){
                        j++;
                    }
                }
            }
        }
        return arr;
    }
}
