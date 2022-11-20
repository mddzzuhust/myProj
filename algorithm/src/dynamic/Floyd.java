package dynamic;

public class Floyd {
    public static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args){
        int[][] weight = {{0,-1,3,-1},
                {2,0,-1,-1},
                {-1,7,0,1},
                {6,-1,-1,0}};

        for(int m=0;m<weight.length;m++){
            for(int i=0;i<weight.length;i++){
                for(int j=0;j<weight.length;j++){
                    if(weight[i][m]!=-1&&weight[m][j]!=-1){
                        if(weight[i][j]==-1||weight[i][j]>weight[i][m]+weight[m][j]) {
                            weight[i][j] = weight[i][m] + weight[m][j];
                        }
                    }
                }
            }
        }

        for(int i=0;i<weight.length;i++){
            for(int j=0;j<weight.length;j++){
                System.out.print(weight[i][j] + " ");
            }
            System.out.println();
        }
    }
}