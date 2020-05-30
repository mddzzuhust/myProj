package dynamic;

public class Triangle {
    public static void main(String[] args){
        int[][] a = {{7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}};
        int[][] b = new int[5][5];

        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                b[i][j]=0;
            }
        }

        b[0][0]=a[0][0];
        int max=-1;
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(j==0){
                    b[i][j]=a[i][j]+b[i-1][j];
                }else if(i==j){
                    b[i][j]=a[i][j]+b[i-1][j-1];
                }else {
                    b[i][j]=a[i][j]+Math.max(b[i-1][j-1],b[i-1][j]);
                }
                if(max<b[i][j]){
                    max=b[i][j];
                }
            }
        }
        System.out.println(max);
    }
}