package sort;

import java.util.Scanner;

public class QuickSort1 {
    public static void QKsort(int[] arr,int low ,int high) {
        if(low<high) {
            int pos = QKpass(arr,low,high);	//划分两个子表
            QKsort(arr,low,pos-1);			//对左子表快排
            QKsort(arr,pos+1,high);			//对右子表快排
        }
    }
    /**
     * 一趟快速排序算法
     * @param arr 待排序数组
     * @param low 数组开始下标
     * @param high数组结束下标
     * @return
     */
    public static int QKpass(int[] arr,int low,int high) {
        int temp = arr[low];		//先把当前元素作为待排值（一趟排序实际上就是把它放到合适的位置）
        while(low < high) {
            while(low < high && arr[high] >= temp)	//从右向左扫描，找到第一个小于temp的值
                high--;
            if(low < high) {						//将此值放入下标为low的数组中
                arr[low] = arr[high];
                low++;
            }
            while(low < high && arr[low] <= temp)	//从左向右扫描找到第一个大于temp的值
                low++;
            if(low < high) {
                arr[high] = arr[low];				//放在下标为high的数组中
                high--;
            }
        }
        arr[low] = temp;							//将此元素放入其准确位置
        return low;									//返回此次排序完成的值当前下标（即此位置的元素已经排好）
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++)
            arr[i] = sc.nextInt();
        sc.close();
        QKsort(arr,0,arr.length - 1);
        for(int x:arr) {
            System.out.print(x + " ");
        }
    }
/**
 * input:10 9 8 7 6 5 4 3 2 1
 * output:1 2 3 4 5 6 7 8 9 10
 */
}

