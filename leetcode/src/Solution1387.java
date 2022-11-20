package leetcode;

import java.util.*;

public class Solution1387 {
    private int getW(int x){
        int count = 0;
        while (x!=1){
            if(x%2==0){
                x=x/2;
                count++;
            }else {
                x = 3*x+1;
                count++;
            }
        }
        return count;
    }
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = lo; i <= hi; i++) {
            int count = getW(i);
            map.put(i,count);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        int result = 0;
        int index = 0;
        while (index<k){
            Map.Entry entry = (Map.Entry)list.get(index);
            result = (Integer)entry.getKey();
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1387 s = new Solution1387();
        System.out.println(s.getKth(1,1000,777));
    }
}
