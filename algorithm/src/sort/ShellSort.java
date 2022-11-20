package sort;

//(1)算法简介
//希尔排序的核心在于间隔序列的设定。
//既可以提前设定好间隔序列，也可以动态的定义间隔序列。
//动态定义间隔序列的算法是《算法（第4版》的合著者Robert Sedgewick提出的。
//
//        (2)算法描述和实现
//        先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
//
//<1>. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
//<2>.按增量序列个数k，对序列进行k 趟排序；
//<3>.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
//    分别对各子表进行直接插入排序。
//    仅增量因子为1 时，整个序列作为一个表来处理，
//    表长度即为整个序列的长度。

//（3）算法分析
//        最佳情况：T(n) = O(nlog2 n)
//        最坏情况：T(n) = O(nlog2 n)
//        平均情况：T(n) =O(nlog n)
public class ShellSort {
    public static void shellSort(int[] array) {
        long start = System.nanoTime();
        int len = array.length;
        int gap = len/2;
        int temp;
        //while(gap < len / 3) gap = 3 * gap + 1;   //目前比较高效的gap
        while(gap > 0){
            for(int i = gap; i < len; i++) {
                for(int j = i; j - gap >= 0 && array[j - gap] > array[j]; j -= gap) {
                    int tmp = array[j - gap];
                    array[j - gap] = array[j];
                    array[j] = tmp;
                }
            }
            gap /= 2;
            //gap /= 3;
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1000.0+"ms");
        for (int j = 0; j < array.length; j++) {
            System.out.printf(array[j]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(array);
    }
}
