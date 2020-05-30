package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        int index = 0;
        List<List<String>> lists = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < paths.length; i++) {
            String[] strings = paths[i].split(" ", 0);

            for (int j = 1; j < strings.length; j++) {
                int mid = strings[j].indexOf('(');
                int end = strings[j].indexOf(')');
                String content = strings[j].substring(mid+1,end);
                String file = strings[j].substring(0,mid);
                if(!map.containsKey(content)){
                    map.put(content,index++);
                    lists.add(new ArrayList<String>());
                }

                lists.get(map.get(content)).add(strings[0]+"/"+file);
            }
        }

        for (int i = lists.size()-1; i >=0; i--) {
            if(lists.get(i).size()<2){
                lists.remove(i);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
// Solution609 solution609 = new Solution609();
//
// String[] paths = {"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"};
//
// List<List<String>> lists = solution609.findDuplicate(paths);
//
// for (int i = 0; i < lists.size(); i++) {
// List<String> list = lists.get(i);
// for (int j = 0; j < list.size(); j++) {
// System.out.print(list.get(j) + " ");
// }
// System.out.println();
// }

        Map paramMap = new HashMap();
        paramMap.put("roomId","abc");
        paramMap.put("empuid","123c");
        paramMap.put("watchTime",123);
        System.out.println(paramMap.get("roomId"));
        System.out.println(paramMap.get("empuid"));
        System.out.println(paramMap.get("watchTime"));
    }
}