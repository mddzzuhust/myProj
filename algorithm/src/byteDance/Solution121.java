package byteDance;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int sz=prices.length;
        int min=0;
        int maxprofit=0;
        for(int i=0;i<sz;i++){
            if(prices[i]<prices[min])
                min=i;
            else{
                int diff=prices[i]-prices[min];
                maxprofit=diff>maxprofit?diff:maxprofit;
            }
        }
        return maxprofit;
    }
}
