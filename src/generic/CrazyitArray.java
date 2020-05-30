package generic;

import java.lang.reflect.Array;

public class CrazyitArray {
    @SuppressWarnings("unchecked")
    public static <T> T[] newInstance(Class<T> componentType,int length){
        return (T[]) Array.newInstance(componentType,length);
    }

    public static void main(String[] args){
        String[] arr = CrazyitArray.newInstance(String.class,10);

        int[][] intArr = CrazyitArray.newInstance(int[].class,5);
        arr[5]="xuyuyanzhongwenwang";

        intArr[1] = new int[]{23,12};
        System.out.println(arr[5]);
        System.out.println(intArr[1][1]);
    }
}