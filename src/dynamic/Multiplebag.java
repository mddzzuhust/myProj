package dynamic;

import java.util.Map;
import java.util.Scanner;

public class Multiplebag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int t = sc.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];
            int[] m = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
                v[i] = sc.nextInt();
                m[i] = sc.nextInt();
            }
            fun(n, t, w, v, m);
        }
    }

    public static void fun(int n, int W, int[] w, int[] v, int[] m) {
        int[] dp = new int[W+1];

        for (int i = 0; i < n; i++){
            for(int k=0;k<m[i];k++){
                for(int j=W;j>=w[i];j--){
                    if(j>=k*w[i]){
                        dp[j] = Math.max(dp[j],dp[j-k*w[i]]+k*v[i]);
                    }
                }
            }
        }

        System.out.println(dp[W]);
    }
}