import java.util.Arrays;

public class Solution2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int begin = bottom;
        int res = 0;
        for (int i = 0; i < special.length; i++) {
            int num = special[i] - begin;
            if(res < num){
                res = num;
            }
            begin = special[i] + 1 ;
        }
        if(special[special.length-1] == top){
            return res;
        }
        if(res < top - special[special.length-1]){
            res = top - special[special.length-1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2274 solution = new Solution2274();
        int[] special = {7,6,8};
        System.out.println(solution.maxConsecutive(6, 8, special));
    }
}
