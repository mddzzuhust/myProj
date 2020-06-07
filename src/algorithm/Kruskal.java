package algorithm;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Kruskal {
    private static int MAX = 100;
    private ArrayList<Edge> edge = new ArrayList<Edge>();//整个图的边
    private ArrayList<Edge> target = new ArrayList<Edge>();//目标边，最小生成树
    private int[] parent = new int[MAX];//标志所在的集合
    private static double INFINITY = 99999999.99;//定义无穷大
    private double mincost = 0.0;//最小成本
    private int n;//结点个数

    public static void main(String args[]){
        Kruskal sp = new Kruskal();
        sp.init();
        sp.kruskal();
        sp.print();
    }
    //初始化
    public void init(){
        Scanner scan = new Scanner(System.in);
        int p,q;
        double w;

        System.out.println("spanning tree begin!Input the node number:");
        n = scan.nextInt();
        System.out.println("Input the graph(-1,-1,-1 to exit)");

        while(true){
            p = scan.nextInt();
            q = scan.nextInt();
            w = scan.nextDouble();
            if(p < 0 || q < 0 || w < 0){
                break;
            }
            Edge e = new Edge();
            e.start = p;
            e.end = q;
            e.cost = w;
            edge.add(e);
        }

        mincost = 0.0;

        for (int i = 1; i <= n; ++i){
            parent[i] = i;
        }
        scan.close();
    }
    //集合合并
    public void union(int j, int k){
        for(int i = 1; i <= n; ++i){
            if(parent[i] == j){
                parent[i] = k;
            }
        }
    }
    //Kruskal算法主体
    public void kruskal(){
        //找剩下的n-2条边
        int i = 0;
        while(i < n-1 && edge.size() > 0){
            //每次取一最小边，并删除
            double min = INFINITY;
            Edge tmp = null;
            for(int j = 0; j < edge.size(); ++j){
                Edge tt = edge.get(j);
                if(tt.cost < min){
                    min = tt.cost;
                    tmp = tt;
                }
            }
            int jj = parent[tmp.start];
            int kk = parent[tmp.end];
            //去掉环，判断当前这条边的两个端点是否属于同一棵树
            if(jj != kk){
                ++i;
                target.add(tmp);
                mincost += tmp.cost;
                union(jj,kk);
            }
            edge.remove(tmp);
        }
        if(i != n-1){
            System.out.println("no spanning tree");
        }
    }
    //打印结果
    public void print(){
        double sum = 0;
        for(int i = 0; i < target.size(); ++i){
            Edge e = target.get(i);
            System.out.println("the " + (i+1) + "th edge:" + e.start + "---" + e.end + "   cost:" + e.cost);
            sum += e.cost;
        }
        System.out.println("the MST cost:"+sum);
    }
}

class Edge
{
    public int start;//始边
    public int end;//终边
    public double cost;//权重
}