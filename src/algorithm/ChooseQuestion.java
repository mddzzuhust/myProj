package algorithm;

import java.util.Scanner;

public class ChooseQuestion {
    /**
     * 从长度为length的数组中找出第k小的元素
     * @param arr	待查找数组
     * @param length数组尾下标
     * @param k		第k小的元素
     * @return		返回第k小的元素的值
     */
    public static int choose(int[] arr,int length,int k) {
        if(k<0 || k>length)			//如果k不满足要求返回
            return -65536;
        else						//否则就用类似快排查找
            return select(arr,0,arr.length-1,k);
    }
    /**
     * 从arr中找第k小的元素
     * @param arr	数组
     * @param left	起始下标
     * @param right	结束下标
     * @param k		第k小
     * @return		返回此值
     */
    public static int select(int[] arr,int left,int right,int k) {
        /*
         * 此种算法类似于快排，但是与快速排序不同的是并不进行完全排序，而是每次只处理其中的一个子问题，查到该值时就返回
         */
        int low = left,high = right, pivot;
        if(left >= right)
            return arr[left];
        pivot = arr[left];
        while(low < high) {
            while(low < high && arr[high] > pivot)
                high--;
            if(low < high) {
                arr[low] = arr[high];
                low++;
            }
            while(low < high && arr[low] < pivot)
                low++;
            if(low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = pivot;	//到此处为止是一趟快速排序的代码，现在我们只要判断本次排序出来的元素是不是第k小
        if(low - left + 1 == k)	//如果是，则直接返回此元素，不再往下查找
            return pivot;
        if(low - left + 1 <k)	//如果要查找的k比它大，我们再去右边查找
            return select(arr,low + 1,right,k - low + left - 1);	//从右边查找的时候我们就要查找的是右边的第k减去上一次枢纽值的正确下标值，即(k-(low-left+1))
        else					//否则就去左边查找
            return select(arr,left,low-1,k);
    }
    public static void swap(int a,int b) {
        int temp = a;
        a = b;
        b = temp;
        return;
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(choose(arr,arr.length-1,5));
    }
/**
 * input:10 9 8 7 6 5 4 3 2 1
 * output:5
 */
}

