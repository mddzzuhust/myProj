package sort;
//(1)算法描述
//冒泡排序是一种简单的排序算法。
//它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
//走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
//这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

//(2)算法描述和实现
//        具体算法描述如下：
//<1>.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
//<2>.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
//<3>.针对所有的元素重复以上的步骤，除了最后一个；
//<4>.重复步骤1~3，直到排序完成。

//(3)算法分析
//        时间复杂度：
//        最佳情况：T(n) = O(n) 当输入的数据已经是正序时
//        最差情况：T(n) = O(n^2) 当输入的数据是反序时
//        平均情况：T(n) = O(n^2)
//        空间复杂度：
//        就空间复杂度而言，可以看到在每次循环中，
//        所需要的额外空间就是在进行数值交换时候的一个额外空间，
//        所以空间复杂度为一个常量O(1)


public class BubbleSort {
    private int i;

    public static void bubbleSort(int[] array) {
        long start = System.nanoTime();
        int len = array.length;
        int i = len - 1;
        while (i>0){
            int pos = 0;
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    pos = j;
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            i = pos;
        }
        long end = System.nanoTime();
        System.out.printf((end-start)/1000.0+"ms");
        for (int j = 0; j < array.length; j++) {
            System.out.printf(array[j]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
    }
}

