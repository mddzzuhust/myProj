package algorithm;

import java.util.Scanner;

public class Prim {
    private static int MAX = 100;
    private static int[][] graph = new int[MAX][MAX];
    private int[] lowcost = new int[MAX];// 标志所在的集合
    private int[] mst = new int[MAX];//
    private static int INFINITY = 99999999;// 定义无穷大
    private int mincost = 0;// 最小成本
    private static int mstcost = 0;// 最小成本
    private static int n;// 结点个数
    private int middle;// 中间结点
    private int sum = 0;

    public static void main(String args[]) {
        Prim sp = new Prim();
        sp.init();
        mstcost = sp.prim(graph, n);
        System.out.println("最小生成树权值和为：" + mstcost);
    }

    // 初始化
    public void init() {
        Scanner scan = new Scanner(System.in);
        int p, q, w;
        System.out.println("spanning tree begin!Input the node number:");
        n = scan.nextInt();
        System.out.println("Input the graph(-1,-1,-1 to exit)");
        while (true) {
            p = scan.nextInt();
            q = scan.nextInt();
            w = scan.nextInt();
            if (p < 0 || q < 0 || w < 0) {
                break;
            }
            graph[p][q] = w;
            graph[q][p] = w;
        }
        scan.close();
    }

    // prim算法主体
    public int prim(int graph[][], int n) {
        for (int i = 2; i <= n; i++) {
            lowcost[i] = graph[1][i];
            mst[i] = 1;
        }
        mst[1] = 0;
        for (int i = 2; i <= n; i++) {
            mincost = INFINITY;
            middle = 0;
            for (int j = 0; j <= n; j++) {
                if (lowcost[j] < mincost && lowcost[j] != 0) {
                    mincost = lowcost[j];
                    middle = j;
                }
            }
            System.out.println(mst[middle] + "--" + middle + "==" + mincost);
            sum += mincost;
            lowcost[middle] = 0;
            for (int j = 0; j <= n; j++) {
                if (graph[middle][j] < lowcost[j]) {
                    lowcost[j] = graph[middle][j];
                    mst[j] = middle;
                }
            }
        }
        return sum;
    }
}
