

import java.util.Arrays;
import java.util.Comparator;

public class Solution5540 {
    public int maxWidthOfVerticalArea(int[][] points) {
        if(points.length==2){
            return Math.abs(points[0][0]-points[1][0]);
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        int gap = points[1][0]-points[0][0];
        for (int i = 2; i < points.length; i++) {
            if(points[i][0]-points[i-1][0]>gap){
                gap = points[i][0]-points[i-1][0];
            }
        }
        return gap;
    }

    public static void main(String[] args) {
        Solution5540 s = new Solution5540();
        int[][] points = new int[][]{{8,7},{9,9},{7,4},{9,7}};
        System.out.println(s.maxWidthOfVerticalArea(points));
    }
}
