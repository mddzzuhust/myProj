package array;

import java.util.Arrays;

//给定一个已排序的整型数组，查找特定元素的位置。如果元素存在，则返回其索引；如果不存在，则返回一个负数
public class ArraysBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 9};
        int i1 = Arrays.binarySearch(arr, 3);
        int i2 = Arrays.binarySearch(arr, 4);
        System.out.println(i1); // 1
        System.out.println(i2); // -3
    }
}
