package leetcode;

import java.util.*;

public class Solution5513 {
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]));
                list.add(i);
                list.add(j);
                lists.add(list);
            }
        }
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                if(a.get(0)==b.get(0)){
                    return a.get(1)-b.get(1);
                }
                return a.get(0)-b.get(0);
            }
        });
        int res = 0;
        int[] target = new int[points.length+1];
        Arrays.fill(target,-1);
        for (int i = 0; i < lists.size(); i++) {
            int x = lists.get(i).get(1);
            int y = lists.get(i).get(2);
            if(target[x]==-1&&target[y]==-1){
                res += lists.get(i).get(0);
                target[x] = y;
            }else {
                if(getEnd(target,x)!=getEnd(target,y)){
                    target[getEnd(target,x)]=getEnd(target,y);
                    res += lists.get(i).get(0);
                }
            }
        }
        return res;
    }
    public int getEnd(int[] target,int i){
        while (target[i]!=-1){
            i = target[i];
        }
        return i;
    }

    public static void main(String[] args) {
        Solution5513 s= new Solution5513();
        int[][] points= new int[][]{{3,12},{-2,5},{-4,1}};
        System.out.println(s.minCostConnectPoints(points));
        System.out.println();
    }
}
