package algorithm;

import java.util.Arrays;

/**
 * @author haiYang
 * @create 2022-02-09 10:44
 */
public class Floyd {
    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        //创建 Graph 对象
        FGraph graph = new FGraph(vertex.length, matrix, vertex);
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
        graph.showAToB('C', 'D', vertex);
    }
}

class FGraph {
    //顶点集合
    private char[] vertex;
    //邻接矩阵
    private int[][] arcs;
    //前驱矩阵
    private int[][] path;

    public FGraph(int vertexNum, int[][] arcs, char[] vertex) {
        this.vertex = vertex;
        this.arcs = arcs;
        this.path = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            Arrays.fill(path[i], i);
        }
    }

    public void show() {
        System.out.println("==========邻接矩阵==========");
        for (int i = 0; i < arcs.length; i++) {
            for (int j = 0; j < arcs.length; j++) {
                System.out.print(arcs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========前驱矩阵==========");
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                System.out.print(vertex[path[i][j]] + " ");
            }
            System.out.println();
        }
    }

    public void floyd() {
        //保存距离
        int len = 0;
        //k为中间顶点
        for (int k = 0; k < arcs.length; k++) {
            //i为开始顶点
            for (int i = 0; i < arcs.length; i++) {
                //j为结束顶点
                for (int j = 0; j < arcs.length; j++) {
                    len = arcs[i][k] + arcs[k][j];
                    if (len < arcs[i][j]) {
                        arcs[i][j] = len;//更新距离
                        path[i][j] = path[k][j];//更新前驱矩阵
                    }
                }
            }
        }

    }

    public void showAToB(char a, char b, char[] vertex) {
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (a == vertex[i]) {
                beginIndex = i;
            }
            if (b == vertex[i]) {
                endIndex = i;
            }
        }
        System.out.println(a + "到" + b + "的距离为：" + arcs[beginIndex][endIndex]);
        System.out.print("路径为：");
        showAToBPath(beginIndex, endIndex, vertex);
        System.out.print(b);
    }

    public void showAToBPath(int beginIndex, int endIndex, char[] vertex) {
        if (path[beginIndex][endIndex] == endIndex && path[beginIndex][endIndex] == beginIndex) {
            return;
        }
        showAToBPath(beginIndex, path[beginIndex][endIndex], vertex);
        System.out.print(vertex[path[beginIndex][endIndex]] + " ");

    }

}


