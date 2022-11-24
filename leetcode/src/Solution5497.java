

import java.util.TreeSet;

public class Solution5497 {
    public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set =new TreeSet<>();
        set.add(0);
        set.add(arr.length+1);
        if(arr.length == m)
            return arr.length;
        int n = arr.length;
        for (int i = n-1; i >=0 ; i--) {
            int index = arr[i];
            int a = set.lower(index);
            int b = set.higher(index);
            if(index-a-1==m||b-index-1==m)
                return i;
            set.add(index);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution5497 s = new Solution5497();
        int[] arr = new int[]{3,5,1,2,4};
        int m =1;
        System.out.println(s.findLatestStep(arr,m));
        System.out.println();
    }
}
