package set;

//给定一个整数列表，其中的数字范围是[0, n]，找出缺失的数字
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7};
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (!numSet.contains(i)) {
                System.out.println("缺失的数字是: " + i);
                break;
            }
        }
    }
}
