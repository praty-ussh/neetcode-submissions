class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int j=1;
        int n = prices.length ;
        int profit = 0;
        while(i<j && j<n && i<n){
int result = 0;
            if(prices[i] > prices[j]){
               i=j;         
            }
            else{
                result = prices[j] - prices[i];
                profit = Math.max(result, profit);
            }
            j++;
        }
        return profit;
    }
}
