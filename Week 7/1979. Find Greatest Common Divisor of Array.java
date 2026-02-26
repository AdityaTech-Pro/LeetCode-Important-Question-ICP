class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int smallest=nums[0];
        int largest=nums[nums.length-1];
        int maxdivisor=0;
        for(int i=1; i<=largest; i++){
            if(smallest % i ==0){
                if(largest % i ==0){
                    maxdivisor=Math.max(maxdivisor,i);
                }
            }
        }
        return maxdivisor;
    }
}
