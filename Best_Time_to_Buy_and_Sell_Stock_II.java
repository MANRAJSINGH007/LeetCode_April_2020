class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, ans = 0;
        if(n == 0) return 0;
        int min = prices[0];
        for(int i = 1; i < n; i++) {
            if(prices[i] == min) continue;
            if(prices[i] < min) min = prices[i];
            else {
                ans += prices[i] - min;
                min = prices[i];
            }
        }
        return ans;
    }
}
