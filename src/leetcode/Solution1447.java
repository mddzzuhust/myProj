package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1447 {
    private int gcd(int m, int n){
        int t = m%n;
        while(t!=0){
            m=n;
            n=t;
            t=m%n;
        }
        return n;
    }
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(gcd(i,j)==1){
                    list.add(String.valueOf(j)+"/"+String.valueOf(i));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution1447 s = new Solution1447();
        List<String> list = s.simplifiedFractions(4);
        System.out.println(list.size());
    }
}
