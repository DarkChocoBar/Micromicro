package airbnb;

public class besttimetobuystock3 {
    public int solution1(int[] prices) {
    	// 1： 从左往右遍历，找到最小值以及最大可能产生的利益，放入dp中
    	// 2： 从右往左遍历，找到最大值以及  这个最大值和（prices【i】 - dp【i-1】） 可以得到的最大差值
    	// 这个差值 = 第二次卖出去最大的价格max - 第二次买入的价格prices【i】 + 第一次买卖获得的利益 ：dp
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int buy1 =  prices[0];
        int buy2 = prices[prices.length - 1];
        int sell1 = 0, sell2 = 0;
        int[] dp = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            dp[i] = sell1;
        }
        


        for (int i = dp.length - 1; i >= 0; i--) {
            buy2 = Math.max(buy2, prices[i]);
            int prev = (i == 0) ? dp[0] : dp[i - 1];
            sell2 = Math.max(sell2, buy2 + prev - prices[i]);
        }
        return sell2;
    }
    
    class Solution2 {
        public int maxProfit(int[] prices) {
            int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
            int sell1 = 0, sell2 = 0;

            for (int i = 0; i < prices.length; i++) {
                //System.out.println("i: " + prices[i]);
                buy1 = Math.min(buy1, prices[i]);
                //System.out.println("buy 1: " + buy1);
                sell1 = Math.max(sell1, prices[i] - buy1);
                //System.out.println("sell 1: " + sell1);
                buy2 = Math.min(buy2, prices[i] - sell1);
               //System.out.println("buy 2: " + buy2);
                sell2 = Math.max(sell2, prices[i] - buy2);
                //System.out.println("sell 2: " + sell2);
                
                System.out.println();
            }

            return sell2;
        }
    }
}
