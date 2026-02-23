class Solution {
    public int findCenter(int[][] edges) {
        // HashMap<Integer, Integer> map=new HashMap<>();
        // for(int[] arr:edges){
        //     for(int x:arr){
        //         map.put(x, map.getOrDefault(x,0)+1);
        //     }
        // }
        // int centerElement=0;
        // int val=0;
        // for(int key:map.keySet()){
        //     val=Math.max(val,map.get(key));
        //     if(val==map.get(key)){
        //         centerElement=key;
        //     }
        // }
        // return centerElement;

//2nd Approach
        int n=edges.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                if(!set.add(edges[i][j])){
                    return edges[i][j];
                }
                set.add(edges[i][j]);
            }
        }
        return 0;
    }
}
