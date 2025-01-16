package array;

import java.util.Arrays;
import java.util.Comparator;

//给定一个整型二维数组，使用Arrays类的方法对其进行排序，按照每行第一个元素升序排序
public class ArraysSort {
    public static void main(String[] args) {
        int[][] arr = {{3, 5}, {1, 2}, {4, 6}};
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        //[1, 2]
        //[3, 5]
        //[4, 6]

    }
}
