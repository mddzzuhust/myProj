package array;

import java.util.Arrays;

//给定两个整型数组，使用Arrays类的方法比较它们是否相等
public class ArraysEqual {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 5, 7, 9, 3};
        int[] arr2 = {1, 4, 5, 7, 9, 3};
        boolean equals = Arrays.equals(arr1, arr2);
        System.out.println(equals); //true
    }
}
