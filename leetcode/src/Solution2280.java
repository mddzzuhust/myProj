import java.util.Arrays;

public class Solution2280 {
    public int minimumLines(int[][] stockPrices) {
        if(stockPrices.length < 2){
            return 0;
        }
        int ans = 1;
        Arrays.sort(stockPrices,(a, b)->a[0]-b[0]);
        long x = (long) stockPrices[1][0] - stockPrices[0][0];
        long y = (long) stockPrices[1][1] - stockPrices[0][1];
        for(int i = 2; i < stockPrices.length; i++){
            long curx = (long) stockPrices[i][0] - stockPrices[i-1][0];
            long cury = (long) stockPrices[i][1] - stockPrices[i-1][1];
            if(cury*x != curx*y){
                ans++;
            }
            x = curx;
            y = cury;
        }
        return ans;
    }
}
