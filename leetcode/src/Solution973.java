

import java.util.Arrays;

public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        Arrays.sort(points,(int[] o1,int[] o2)->((o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1])));
        System.arraycopy(points,0,ans,0,K);
        return ans;
    }
}
