package dynamic;

public class Dijkstra {
    public static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args){
        int[][] weight = {{0,50,70,MAX,MAX},
                {50,0,15,30,MAX},
                {70,15,0,MAX,40},
                {MAX,30,MAX,0,20},
                {MAX,MAX,40,20,0}};

        int start=0;
        int[] visited=new int[weight.length];
        int[] shortpath=new int[weight.length];

        for(int i=0;i<visited.length;i++){
            visited[i]=0;
            shortpath[i]=0;
        }
        visited[start]=1;

        for(int i=1;i<weight.length;i++){
            int index=-1;
            int min_path=MAX;

            for(int j=0;j<weight.length;j++){
                if(visited[j]==0&&weight[start][j]<min_path){
                    index=j;
                    min_path=weight[start][j];
                }
            }

            shortpath[index]=min_path;
            visited[index]=1;

            for(int j=0;j<weight.length;j++){
                if(visited[j]==0&&weight[index][j]<MAX&&weight[start][j]>weight[start][index]+weight[index][j]){
                    weight[start][j]=weight[start][index]+weight[index][j];
                }
            }
        }

        for(int i=0;i<weight.length;i++){
            System.out.println(shortpath[i]);
        }
    }
}