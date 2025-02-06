import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0)  return 0;
        int max=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<=height.length;i++){
            int currentH=(i==height.length?-1:height[i]);
            while(!stack.isEmpty()&&height[stack.peek()]>currentH){
                int h=height[stack.pop()];
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                max=Math.max(max,h*w);
            }
            stack.push(i);
        }
        return max;
    }
    public static void main(String[] args){
        Solution84 s = new Solution84();
        int[] num=new int[]{2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(num));
    }
}
