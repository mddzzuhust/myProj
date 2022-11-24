

import java.util.HashSet;
import java.util.Set;

public class Solution1319 {
    int[] father;
    int num;
    int[] sz;
    private void initUF(int n){
        father = new int[n];
        sz = new int[n];
        num = n;
        for (int i = 0; i < n; i++) {
            father[i]=i;
            sz[i]=1;
        }
    }
    private int find(int p){
        if(p!=father[p]){
            p = find(father[p]);
        }
        return p;
    }
    private void union(int f, int t){
        int i = find(f);
        int j = find(t);
        if(i==j)
            return;
        num -= 1;
        if(sz[i]<sz[j]){
            father[i] = j;
            sz[j] += sz[i];
        }else {
            father[j] = i;
            sz[i] += sz[j];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        initUF(n);
        int cnt = 0;
        for(int[] c:connections){
            int f = c[0],t=c[1];
            if(find(f)==find(t)){
                cnt++;
                continue;
            }
            union(f,t);
        }
        int cnt2 = num-1;
        if(cnt<cnt2){
            return -1;
        }
        return cnt2;
    }
}
