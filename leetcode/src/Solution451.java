package leetcode;

import java.util.*;

public class Solution451 {
    public String frequencySort(String s) {
        Map map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),(int)map.get(s.charAt(i))+1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character,Integer> mapping:list){
            StringBuffer tmp = new StringBuffer();
            for (int i = 0; i < mapping.getValue(); i++) {
                tmp.append(mapping.getKey());
            }
            sb.append(tmp.toString());
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Solution451 s = new Solution451();
        String str = "Aabb";
        System.out.println(s.frequencySort(str));
    }
}
