package byteDance;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<length; i++){
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
