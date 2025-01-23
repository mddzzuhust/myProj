public class Solution2865 {
    public long maximumSumOfHeights(int[] heights) {
        if(heights.length == 1){
            return heights[0];
        }
        if(heights.length == 2){
            return heights[0] + heights[1];
        }
        long result = heights[0];
        int maxFac = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if(heights[i] <= maxFac){
                result += heights[i];
                maxFac = heights[i];
            }else {
                result += maxFac;
            }
        }

        long lastSum = heights[heights.length - 1];
        maxFac = heights[heights.length - 1];
        for (int i = heights.length -2; i >= 0; i--) {
            if(heights[i] <= maxFac){
                lastSum += heights[i];
                maxFac = heights[i];
            }else {
                lastSum += maxFac;
            }
        }

        if(lastSum > result){
            result = lastSum;
        }

        for (int i = 1; i < heights.length - 1; i++) {
            if(heights[i] >= heights[i-1] && heights[i] >= heights[i+1]){
                long tmpSum = heights[i];
                int maxFactor = heights[i];
                for(int j = i-1; j >= 0; j--){
                    if(heights[j] <= maxFactor){
                        tmpSum += heights[j];
                        maxFactor = heights[j];
                    }else {
                        tmpSum += maxFactor;
                    }
                }
                maxFactor = heights[i];
                for (int j = i+1; j < heights.length; j++) {
                    if(heights[j] <= maxFactor){
                        tmpSum += heights[j];
                        maxFactor = heights[j];
                    }else {
                        tmpSum += maxFactor;
                    }
                }

                if(tmpSum > result){
                    result = tmpSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2865 solution = new Solution2865();
        System.out.println(solution.maximumSumOfHeights(new int[]{1000000000,1000000000,1000000000}));
    }
}
