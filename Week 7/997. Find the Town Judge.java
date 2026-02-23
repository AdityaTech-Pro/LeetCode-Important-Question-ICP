class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        HashMap<Integer, Integer>in=new HashMap<>();
        HashMap<Integer, Integer>out=new HashMap<>();
        
        int ans=-1;
        for(int i=0; i<trust.length; i++){
            out.put(trust[i][0],out.getOrDefault(trust[i][0],0)+1);
            in.put(trust[i][1],in.getOrDefault(trust[i][1],0)+1);
        }
        for(int key:in.keySet()){
            if(n-1==in.get(key)){
                ans=key;
                if(out.get(ans)==null){
                    return ans;
                }
                else{
                    ans=-1;
                    continue;
                }
            }
        }
        return ans;
    }
}
