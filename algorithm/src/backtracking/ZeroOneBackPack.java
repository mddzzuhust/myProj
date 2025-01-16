package backtracking;

/*
* 问题描述：
*有N件物品和一个容量为C的背包。第i件物品的价值是v[i]，重量是w[i]。
* 求解将哪些物品装入背包可使价值总和最大。所谓0-1背包，表示每一个物品不能拆解，要么装入，要么不装入。
* https://blog.csdn.net/zr147258369/article/details/114886524
* */

import java.util.Arrays;
import java.util.Scanner;

public class ZeroOneBackPack {
    private final static int  N = 999;
    public static int SumValue = 0;
    public static int SumWeight = 0;
    public static int OptimalValue = 0;
    public static int OptimalSolution[] = new int[N];
    public static int w[] = new int[N];
    public static int v[] = new int[N];
    public static int x[] = new int[N];
    public static int n;
    public static int c;

    public static void  backTracking(int t) {
        if(t>n) {
            if(SumValue > OptimalValue) {
                OptimalValue = SumValue;
                for(int i=1;i<=n;i++)
                    OptimalSolution[i]=x[i];
            }
        }else {
            for(int i=0;i<=1;i++) {
                x[t]=i;
                if(i==0) {
                    backTracking(t+1);
                }else {
                    if(SumValue+w[t]<=c) {
                        SumWeight += w[t];
                        SumValue += v[t];
                        backTracking(t+1);
                        SumValue -= v[t];
                        SumWeight -= w[t];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(w, 0);
        Arrays.fill(v, 0);
        Arrays.fill(x, 0);
        c = sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            int temp = sc.nextInt();
            w[i]=temp;
            temp = sc.nextInt();
            v[i]=temp;
        }
        backTracking(1);
        System.out.print(OptimalValue);
    }
}

