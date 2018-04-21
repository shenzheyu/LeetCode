public class Solution {

    public static int maxProfit(int[] prices) {
        int[] maxHelper = new int[prices.length];
        int maxToEnd = 0;
        int res = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > maxToEnd) {
                maxToEnd = prices[i];
            }
            maxHelper[i] = maxToEnd;
        }
        for(int i = 0; i < prices.length; i++) {
            if(res < maxHelper[i] - prices[i]) {
                res = maxHelper[i] - prices[i];
            }
        }
        return res;
    }

}
