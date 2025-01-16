package array;

import java.util.Arrays;

//给定一个整型数组，使用Arrays类的方法将其所有元素填充为指定的值
public class ArraysFill {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 7, 9, 3};
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));
    }
}
