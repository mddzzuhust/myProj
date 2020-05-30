package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int max=1;
        for (int i = 0; i < arr.length; i++) {
            Integer val = map.get(arr[i]-difference);
            if(val!=null){
                map.put(arr[i],val+1);
                if(max<val+1){
                    max = val+1;
                }
            }else {
                map.put(arr[i],1);
            }
        }
        return max;
    }
}