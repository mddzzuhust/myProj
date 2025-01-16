package array;

import java.util.Arrays;
//给定一个整型数组，去除数组中的重复元素，并返回一个没有重复元素的新数组，并求出最大值和最小值
public class ArraysStream2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 3, 3, 3, 5, 5, 6, 8, 9};
        int[] arr2 = Arrays.stream(arr1)
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(arr2)); //[1, 3, 5, 6, 8, 9]

        int max = Arrays.stream(arr2).max().getAsInt();
        int min = Arrays.stream(arr2).min().getAsInt();
        System.out.println(max); // 9
        System.out.println(min); // 1
    }
}
