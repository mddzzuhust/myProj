package array;

import java.util.Arrays;

//给定一个整型数组，使用Arrays类的方法将其复制到一个新的数组中
public class ArraysCopy {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 5, 7, 9, 3};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr2)); //[1, 4, 5, 7, 9, 3]
    }
}
