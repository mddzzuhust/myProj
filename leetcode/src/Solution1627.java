

import java.util.ArrayList;
import java.util.List;

public class Solution1627 {
    class UnionFind{
        private int[] parent;
        private int[] weight;
        private int size;
        private int groups;

        public UnionFind(int size){
            this.parent = new int[size];
            this.weight = new int[size];
            this.size = size;
            this.groups = size;

            for (int i = 0; i < size; i++) {
                this.parent[i] = i;
                this.weight[i] = 1;
            }
        }

        public int find(int element){
            while (element!=parent[element]){
                parent[element]  = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        public boolean isConnected(int firstElement,int secondElement){
            return find(firstElement) == find(secondElement);
        }

        public void unionElements(int firstElement,int secondElement){
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);

            if(firstRoot == secondRoot){
                return;
            }

            if(weight[firstRoot]>weight[secondElement]){
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
            }else {
                parent[firstRoot] = secondRoot;
                weight[secondRoot] += weight[firstRoot];
            }

            this.groups--;
        }

        public int getGroups(){
            return this.groups;
        }
    }

    public List<Boolean> areConnected(int n,int threshold,int[][] queries){
        List<Boolean> list = new ArrayList<>();
        if(threshold==0){
            for (int i = 0; i < queries.length; i++) {
                list.add(true);
            }
            return list;
        }
        UnionFind union = new UnionFind(n);
        for (int i = threshold+1; i <= n; i++) {
            int times = 2;
            while (i*times<=n){
                union.unionElements(i-1,i*times-1);
                times += 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            list.add(union.isConnected(first-1,second-1));
        }
        return list;
    }
}
