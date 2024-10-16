import java.util.HashMap;
import java.util.Map;

public class Solution3164 {
    public static void main(String[] args) {
        Solution3164 solution3164 = new Solution3164();
        int[] nums1 = new int[]{1,3,4};
        int[] nums2 = new int[]{1,3,4};
        long res = solution3164.numberOfPairs(nums1, nums2, 1);
        System.out.println(res);
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        int max1 = 0;
        for(int num : nums1){
            count.put(num, count.getOrDefault(num,0)+1);
            max1 = Math.max(max1, num);
        }
        for(int num : nums2){
            count2.put(num, count2.getOrDefault(num,0)+1);
        }
        long res = 0;
        for(int a : count2.keySet()){
            for(int b = a*k;b<=max1;b+=a*k){
                if(count.containsKey(b)){
                    res += 1L * count.get(b)*count2.get(a);
                }
            }
        }
        return res;
    }
}
