package array;

public class MergeSortedArrays {
    public static void merge(int[] A, int m, int[] B, int n, int[] C) {
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        // 如果 A 数组有剩余元素，则复制到 C 数组
        while (i < m) {
            C[k++] = A[i++];
        }

        // 如果 B 数组有剩余元素，则复制到 C 数组
        while (j < n) {
            C[k++] = B[j++];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        int[] B = {2, 4, 6};
        int[] C = new int[A.length + B.length];

        merge(A, A.length, B, B.length, C);

        // 打印合并后的数组
        for (int num : C) {
            System.out.print(num + " ");
        }
    }
}
