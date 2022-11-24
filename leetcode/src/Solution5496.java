

import java.util.Arrays;

public class Solution5496 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        int index = 0;
        int back = piles.length-1;
        while (index<piles.length/3){
            sum = sum + piles[back-1];
            back = back-2;
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution5496 s = new Solution5496();
        int[] piles = new int[]{9,8,7,6,5,1,2,3,4};
        System.out.println(s.maxCoins(piles));
        System.out.println();
    }
}
