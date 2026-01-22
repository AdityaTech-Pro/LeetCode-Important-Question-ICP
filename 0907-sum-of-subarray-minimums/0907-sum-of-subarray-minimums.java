class Solution {
    public int sumSubarrayMins(int[] arr) {
        // Stack<Integer> st=new Stack<>();
        // ArrayList<Integer> array=new ArrayList<>();
        // int idx=0;
        // int sum=0;
        // for(int i=0; i<arr.length; i++){
        //     while(!st.isEmpty() && (i==arr.length || arr[st.peek()]>arr[i])){
        //         int j=st.pop();
        //         array.add(arr[j]);
                
        //     }
        //     st.push(i);
        // }
        // for(int i=0; i<array.size(); i++){
        //     sum+=array.get(i);
        // }
        // return (int)sum%1000000007;
        // long mod=1000000007;
        // long sum=0; 
        // for(int i=0; i<arr.length-1; i++){
        //     int mini=arr[i];
        //     for(int j=i; j<arr.length-1; j++){
        //         mini=Math.min(mini, arr[j]);
        //         sum=(int)(sum+mini)%mod;
        //     }
        // }
        // return (int)sum;

        Stack<int[]> stack = new Stack<>();
        int[] res = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            // use ">=" to deal with duplicate elements
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }

            int j = stack.isEmpty() ? -1 : stack.peek()[1];
            res[i] = stack.isEmpty() ? arr[i] * (i + 1) : res[j] + arr[i] * (i - j);
            stack.push(new int[]{arr[i], i});
        }

        long MOD = (long) 1000000007;
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans = (ans + (long) res[i]) % MOD;
        }
        return (int) ans;        
    }
}