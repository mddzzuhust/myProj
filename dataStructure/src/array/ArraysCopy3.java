package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//合并两个int[]类型的数组，得到一个int[]类型的数组，再转换成List<Integer>类型
public class ArraysCopy3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10, 12};
        int[] arr3 = Arrays.copyOf(arr1, arr1.length + arr2.length);

        System.out.println(Arrays.toString(arr3)); //[1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0]

        //从arr2的0号元素开始，复制到arr3，从arr3的arr1.length号元素开始，复制arr2.length个元素
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr3)); //[1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 12]

        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3)); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]

        List<Integer> list = Arrays.stream(arr3)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);                  //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]

    }
}
