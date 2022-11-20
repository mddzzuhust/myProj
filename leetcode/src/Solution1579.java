package leetcode;

import java.util.Arrays;

public class Solution1579 {
    boolean[] used ;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        used = new boolean[edges.length];
        Arrays.sort(edges,(a, b)->Integer.compare(b[0],a[0]));
        if(!unionFind(n,edges,1))
            return -1;
        if(!unionFind(n,edges,2))
            return -1;
        int result = 0;
        for (boolean u:used) {
            result += u?0:1;
        }
        return result;
    }

    private boolean unionFind(int n,int[][] edges,int excludeType){
        int[] union = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            union[i] = i;
        }
        int ctn = 0;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if(edge[0]==excludeType)
                continue;
            int rootA = findRoot(union,edge[1]);
            int rootB = findRoot(union,edge[2]);
            if(rootA!=rootB){
                ctn+=1;
                union[rootA] = rootB;
                used[i]=true;
            }
            if(ctn == n-1)
                return true;
        }
        return false;
    }

    private int findRoot(int[] union,int idx){
        if(union[idx]!=idx){
            int root = findRoot(union,union[idx]);
            union[idx] = root;
            return root;
        }
        return idx;
    }

    public static void main(String[] args) {
        Solution1579 s = new Solution1579();
        int[][] edges =new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(s.maxNumEdgesToRemove(4,edges));
        System.out.println();
    }
}
