

import java.util.Arrays;
import java.util.Comparator;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null)
            return null;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });

        int[][] result = new int[people.length][2];
        int index = 0;
        for (int i = 0; i < people.length; i++) {
            if(people[i][1]>=index){
                result[index][0] = people[i][0];
                result[index][1] = people[i][1];
                index++;
            }else {
                for (int j = index-1; j >=people[i][1] ; j--) {
                    result[j+1][0] = result[j][0];
                    result[j+1][1] = result[j][1];
                }
                result[people[i][1]][0] = people[i][0];
                result[people[i][1]][1] = people[i][1];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution406 s = new Solution406();
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(s.reconstructQueue(people));
        System.out.println("\n");
    }
}
