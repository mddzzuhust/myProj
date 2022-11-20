package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1654 {
    class Node {
        private int pla;
        private int back;

        public Node(int pla, int back) {
            this.pla = pla;
            this.back = back;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        final int MAX = 100050;
        boolean[] take = new boolean[MAX];
        for(int fob: forbidden) take[fob] = true; // 标记不能跳的点

        int[][] dist = new int[MAX][2]; // 用于记录往前跳与往后跳的次数
        for(int i = 0; i < MAX; i++){ // 进行初始化
            for(int j = 0; j < 2; j++){
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;

        Queue<Node> que = new LinkedList<>(); // 创造队列
        que.offer(new Node(0, 0));

        // bfs 思路
        while(!que.isEmpty()){
            Node now = que.poll();
            // 往前跳
            if(now.pla + a < MAX && !take[now.pla + a] && dist[now.pla + a][0] == -1){
                dist[now.pla + a][0] = dist[now.pla][now.back] + 1;
                que.offer(new Node(now.pla + a, 0));
            }
            // 往后跳
            if(now.back != 1 && now.pla - b >= 0 && !take[now.pla - b] && dist[now.pla - b][1] == -1){
                dist[now.pla - b][1] = dist[now.pla][now.back] + 1;
                que.offer(new Node(now.pla - b, 1));
            }
        }

        // 针对终点进行结果查询
        int ans = -1;
        if(dist[x][0] != -1 && (ans == -1 || ans > dist[x][0])) ans = dist[x][0];
        if(dist[x][1] != -1 && (ans == -1 || ans > dist[x][1])) ans = dist[x][1];

        return ans;
    }

    public static void main(String[] args) {
        Solution1654 s = new Solution1654();
        int[] fobbiden = new int[]{8,3,16,6,12,20};
        System.out.println(s.minimumJumps(fobbiden,15,13,11));
    }
}
