package sort;

//(1)算法简介
//选择排序(Selection-sort)是一种简单直观的排序算法。
//它的工作原理：首先在未排序序列中找到最小（大）元素，
//存放到排序序列的起始位置，然后，
//再从剩余未排序元素中继续寻找最小（大）元素，
//然后放到已排序序列的末尾。以此类推，
//直到所有元素均排序完毕。
//
//(2)算法描述和实现
//n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
//
//<1>.初始状态：无序区为R[1..n]，有序区为空；
//<2>.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
//    该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
//    将它与无序区的第1个记录R交换，
//    使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
//<3>.n-1趟结束，数组有序化了。

//(3)算法分析
//        时间复杂度：
//        最佳情况：T(n) = O(n^2)
//        最差情况：T(n) = O(n^2)
//        平均情况：T(n) = O(n^2)
//        空间复杂度：
//        同冒泡排序一样，占用常数的额外空间，所以空间复杂度为O(1)
public class SelectionSort {
    public static void selectSort(int[] array){
        long start = System.nanoTime();
        int len = array.length;
        int minIndex = 0;
        for (int i = 0; i < len-1; i++) {
            minIndex = i;
            for (int j = i+1; j < len; j++) {
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i]=tmp;
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1000.0+"ms");

        for (int j = 0; j < array.length; j++) {
            System.out.printf(array[j]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectSort(array);
    }
}
