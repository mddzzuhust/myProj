package array;

import java.util.Arrays;
//给定一个整型数组，使用Arrays.copyOf方法创建一个新的数组，新数组是原数组的一个副本，但是长度是原数组长度的两倍
public class ArraysCopy2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6, 7, 8, 9};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length * 2);
        System.out.println(Arrays.toString(arr2)); //[1, 3, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0]
    }
}
