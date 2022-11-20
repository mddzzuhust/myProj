package leetcode;

public class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int l = 0; l <= n-m*k; l++) {
            int offset=0;
            for (; offset < m*k; offset++) {
                if(arr[l+offset]!=arr[l+offset%m])
                    break;
            }
            if(offset==m*k){
                return true;
            }
        }
        return false;
    }
}
