package dynamic;

public class totalbag {
    public static void main(String[] args){
        int[] weight={3,4,6,2,5};
        int[] value={6,8,7,5,9};

        int m=10;
        int[] f=new int[m+1];

        for (int i=0;i<f.length;i++){
            f[i]=0;
        }

        for(int i=0;i<value.length;i++){
            for(int j=weight[i];j<f.length;j++){
                f[j]=Math.max(f[j],f[j-weight[i]]+value[i]);
            }
        }

        for(int i=0;i<f.length;i++){
            System.out.print(f[i]+ " ");
        }
    }
}