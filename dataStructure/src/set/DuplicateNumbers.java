package set;
//给定一个整数数组，找出其中的重复数字
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 5};
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                System.out.println("重复的数字是: " + num);
                break;
            } else {
                numSet.add(num);
            }
        }
    }
}
