package dynamic;

public class touzifenpei {
    public static void main(String[] args){
        int M=4,N=7;
        int money=60;

        int[][] array=new int[7][7];
        int[][] array1=new int[7][7];

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(i==0){
                    array1[i][j]=array[i][j];
                }else {
                    for(int k=0;k<N;k++){
                        if(j-k>=0){
                            if(array1[i][j]<array[i][k]+array1[i-1][j-k]){
                                array1[i][j]=array[i][k]+array1[i-1][j-k];
                            }
                        }else {
                            break;
                        }
                    }
                }
            }
        }
    }
}