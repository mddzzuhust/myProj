package dynamic;

public class zerobag {
    public static void main(String[] args){
        int[] weight={3,5,2,6,4};
        int[] value={4,4,3,5,3};

        int m=12;
        int[] f=new int[m+1];

        for(int i=0;i<f.length;i++){
            f[i]=0;
        }

        for(int i=0;i<value.length;i++){
            for(int j=f.length-1;j>=weight[i];j--){
                f[j]=Math.max(f[j],f[j-weight[i]]+value[i]);
            }
        }

        for(int i=0;i<f.length;i++){
            System.out.print(f[i]+ " ");
        }
    }
}