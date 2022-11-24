

public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold+prices[i]-fee);
            hold = Math.max(hold, cash-prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        Solution714 s = new Solution714();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(s.maxProfit(prices,2));
    }
}
