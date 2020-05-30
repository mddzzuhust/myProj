package dynamic;

import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        sc.nextLine();
        String s = sc.nextLine();
        String[] arrs = s.split(" ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }
        System.out.println(getMaxLength(arr,len));
    }

    public static int getMaxLength(int[] array,int numsize){
        if(numsize<2){
            return numsize;
        }

        int[] store = new int[numsize];
        store[0] = array[0];
        int length = 1;
        int position;
        for (int i = 1; i < numsize; i++) {
            if(array[i]>store[length-1]){
                store[length++] = array[i];
            }else {
                position = halfSearch(store,array[i],length);
//System.out.println(position);
                store[position] = array[i];
            }
        }
        return length;
    }

    public static int halfSearch(int[] array, int key, int length){
        int left = 0;
        int right = length-1;
        int middle = 0;
        while (left<=right){
            middle = left + (right-left)/2;
            if (array[middle]>key){
                right = middle-1;
            }else if(array[middle]<key){
                left = middle+1;
            }else {
                return middle;
            }
        }
        return left;
    }
}