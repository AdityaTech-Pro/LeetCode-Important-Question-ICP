class Solution {
    public int findTheWinner(int n, int k) {
        int ans=0;
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            if(q.size()==1){
                ans=q.poll();
                break;
            }
            count++;
            if(count==k){
                q.remove();
                count=0;
            }
            else{
                q.add(q.poll());
            }
        }
        return ans;
    }
}
