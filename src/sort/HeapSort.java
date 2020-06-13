package sort;

//堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
//堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
//
//算法描述
//将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
//将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
//由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
//得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

//最佳情况：T(n) = O(nlogn)
//最差情况：T(n) = O(nlogn)
//平均情况：T(n) = O(nlogn)
public class HeapSort {
    static int len;

    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1)
            return array;
        buildHeap(array);
        while (len>0){
            swap(array,0,len-1);
            len--;
            adjustHeap(array,0);
        }
        return array;
    }

    public static void buildHeap(int[] array){
        for (int i = (len/2-1); i >= 0; i--) {
            adjustHeap(array,i);
        }
    }

    public static void adjustHeap(int[] array, int i){
        int maxIndex = i;
        if(i*2<len&&array[i*2]>array[maxIndex])
            maxIndex = i*2;
        if(i*2+1<len&&array[i*2+1]>array[maxIndex])
            maxIndex = i*2+1;
        if(maxIndex!=i){
            swap(array,maxIndex,i);
            adjustHeap(array,maxIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        HeapSort heapSort = new HeapSort();
        int[] result = heapSort.HeapSort(array);

        for (int j = 0; j < result.length; j++) {
            System.out.printf(result[j]+" ");
        }
    }
}
