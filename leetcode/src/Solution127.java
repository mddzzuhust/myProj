public class Solution127 {
    public int trainWays(int num) {
        if(num == 0) {
            return 0;
        }
        if(num==1){
            return 1;
        }
        if(num==2){
            return 2;
        }
        int first = 1;
        int second = 2;
        for(int i=3;i<=num;i++){
            int tmp = (first + second)%1000000007;
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        Solution127 solution = new Solution127();
        System.out.println(solution.trainWays(0));
    }
}
