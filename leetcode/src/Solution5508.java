package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution5508 {
    public int numTriplets(int[] nums1, int[] nums2) {
        return numTriplet(nums1,nums2) + numTriplet(nums2,nums1);
    }

    int numTriplet(int[] nums1,int[] nums2){
        int res = 0;
        if(nums1.length<2){
            return res;
        }

        Map<Long,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length-1; i++) {
            for (int j = i+1; j < nums1.length; j++) {
                long tmp = (long)nums1[i]*(long)nums1[j];
                map.put(tmp,map.getOrDefault(tmp,0)+1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            long tmp = (long)nums2[i]*(long)nums2[i];
            if(map.containsKey(tmp)){
                res = res + map.get(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5508 s = new Solution5508();
        int[] nums1 = new int[]{1,1};
        int[] nums2 = new int[]{1,1,1};
        System.out.println(s.numTriplets(nums1,nums2));
        System.out.println();
    }
}
