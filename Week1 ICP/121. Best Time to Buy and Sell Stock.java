//leetcode submition link:  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1890646104/

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=prices[0];
        for(int i=0; i<prices.length; i++){
            if(prices[i]<buy){
                buy=prices[i];
            }
            profit=Math.max(profit, prices[i]-buy);
        }
        return profit;
    }
}
