package array;

import java.util.Arrays;
//给定一个整型数组，将该数组的所有元素乘以2，赋值给一个新数组
public class ArraysStream {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6, 7, 8, 9};
        int[] arr2 = Arrays.stream(arr1)
                .map(i -> i * 2)
                .toArray();
        System.out.println(Arrays.toString(arr2)); //[2, 6, 10, 12, 14, 16, 18]
    }
}
