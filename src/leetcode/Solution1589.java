package leetcode;

import Greedy.Solution;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Solution1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < requests.length; i++) {
            for (Integer j = requests[i][0]; j <=requests[i][1] ; j++) {
                Integer count = map.get(j);
                if(count!=null){
                    map.put(j,map.get(j)+1);
                }else {
                    map.put(j,1);
                }
            }
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
        //降序排序
        @Override
        public int compare(Map.Entry<Integer, Integer> o1,
                Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
                }
        });

        Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        Arrays.sort(nums);
        Integer sum = 0;
        int index = nums.length-1;
        for(Map.Entry<Integer,Integer> entry : result.entrySet()){
            Integer count = entry.getValue();
            sum = sum + nums[index]*count;
            index--;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1589 s = new Solution1589();
        int[] nums = new int[]{1,2,3,4,5,10};
        int[][] requests = new int[][]{{0,2},{1,3},{1,1}};
        System.out.println(s.maxSumRangeQuery(nums,requests));
    }
}
