// Leetcode submition link: https://leetcode.com/problems/first-missing-positive/submissions/1892988581/

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num=1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==num){
                num++;
            }
        }
        return num;
    }
}
