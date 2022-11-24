

import java.util.*;

public class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        int result = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> tmp = (Map.Entry<Integer,Integer>)iterator.next();
            if(tmp.getValue()==0)
                break;
            if(tmp.getKey()*2==k){
                result = result + tmp.getValue()/2;
                map.put(tmp.getKey(),0);
            }else {
                if(!map.containsKey(k-tmp.getKey())){
                    continue;
                }
                int value1 = tmp.getValue();
                int value2 = map.get(k-tmp.getKey());
                if(value1>=value2){
                    result = result + value2;
                    map.put(k-tmp.getKey(),0);
                }else{
                    result = result + value1;
                    map.put(tmp.getKey(),0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1679 s = new Solution1679();
        int[] nums = new int[]{48,87,82,57,69,63,33,58,71,7,44,52,81,34,68,24,20,10,3,82,59,20,59,10,66,62,51,57,3,24,10,84,3,16,77,27,90,5,35,56,27,82,21,14,20,31,23,23,15,87,73,13,8,29,27,74,80,61,77,19,10,20,4,81,74,11,63,72,77,78,32,90,77,32,85,78,48,38,63,82,69,59,85,82,43,54,44,32,71,5,69,5,42,65,61,34,13,89,76,71,77,37,6,50,53,13,30,5,86,5,88,53,23,53,38,29,83,70,36,74,68,37,15,78,17,85};
        System.out.println(s.maxOperations(nums,12));
    }
}
