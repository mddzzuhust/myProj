package byteDance;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        quanpailie(num, 0, num.length, llist);
        return llist;
    }
    public static void swap(int[] num,int a,int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    public static void quanpailie(int[] num,int l,int n,List<List<Integer>> llist){
        if (l >= n) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) {
                list.add(num[i]);
            }
            llist.add(list);
        }
        for (int i = l; i < n; i++) {
            swap(num, i, l);
            quanpailie(num, l+1, n,llist);
            swap(num, i, l);
        }
    }
}
