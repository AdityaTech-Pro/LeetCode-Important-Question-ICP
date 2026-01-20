class Solution {
    public int maxSumMinProduct(int[] n) {
        // long mod=1000000007;
        // int max=Integer.MAX_VALUE;
        // int sum=0;
        // ArrayList<Integer>arr=new ArrayList<>();
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]>1){
        //         arr.add(nums[i]);
        //     }
            
        // }
        // int min=Collections.min(arr);
        // for(int i=0; i<nums.length-1; i++){
        //     sum = (sum + arr.get(i));
        // }
        // //long ans= (sum*min) ;
        
        // return sum*min;
      
        Stack<Integer> st = new Stack<>();
        long dp[] = new long[n.length + 1], res = 0;
        for (int i = 0; i < n.length; ++i){
        dp[i + 1] = dp[i] + n[i];
        }
        for (int i = 0; i <= n.length; ++i) {
            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();
                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }
            st.push(i);
        }
        return (int)(res % 1000000007);
    }
}