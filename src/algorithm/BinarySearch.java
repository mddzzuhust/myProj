package algorithm;

import java.util.Scanner;

public class BinarySearch {
    /**
     * 二分查找
     * @param num 需要查找的数组(必须为有序数列)
     * @param n 待查找的值
     * @param left 数组开始下标
     * @param right	数组结尾下标
     * @return	返回该值在数组中的位置，不存在则返回-1
     */
    public static int Search(int[] num,int n,int left,int right) {
        int mid = (left + right) / 2;
        if(n == num[mid])
            return mid+1;			//若n等于当前中间元素则返回下标
        if(left<right) {			//如果left小于right，说明没有查找完
            if(n > num[mid])		//如果大于中间值，则从右半部查找
                return Search(num,n,mid+1,right);
            else					//否则从左半部查找
                return Search(num,n,left,mid-1);
        }
        return -1;					//right大于left，n不存在数组中，返回-1
    }
    public static void main(String[] args) {
        int[] nums = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<nums.length;i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(Search(nums,5,0,nums.length-1));
    }

}
/**
 * input:1 2 3 4 5 6 7 8 9 10
 * output:5
 */

