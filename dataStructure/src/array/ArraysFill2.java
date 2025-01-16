package array;

import java.util.Arrays;

//给定一个整型数组，将数组的前三个元素填充为3
public class ArraysFill2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 9};
        Arrays.fill(arr,0,3,3);
        System.out.println(Arrays.toString(arr)); //[3, 3, 3, 6, 7, 8, 9]
    }
}
